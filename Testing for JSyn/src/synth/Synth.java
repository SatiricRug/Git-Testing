package synth;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.ports.UnitInputPort;
import com.jsyn.swing.DoubleBoundedRangeModel;
import com.jsyn.swing.PortModelFactory;
import com.jsyn.swing.RotaryTextController;
import com.jsyn.unitgen.ImpulseOscillator;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.TriangleOscillator;

public class Synth extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	private Synthesizer synth;
	
	private static final int NUM_OF_STEPS = 8;
	
	private static int sizeX = 770;
	private static int sizeY = 300;
	
	public Synth() {
		//AUDIO
		
		synth = JSyn.createSynthesizer();
		LineOut lineOut = new LineOut();
		TriangleOscillator osc = new TriangleOscillator();
		Sequencer seq = new Sequencer(NUM_OF_STEPS);
		ImpulseOscillator clock = new ImpulseOscillator();
		
		synth.add(lineOut);
		synth.add(osc);
		synth.add(seq);
		synth.add(clock);
		
		clock.getOutput().connect(seq.clock);
		seq.getOutput().connect(osc.frequency);
		osc.getOutput().connect(0, lineOut.input, 0);
		osc.getOutput().connect(0, lineOut.input, 1);
		
		osc.amplitude.setup(0, .5, 1);
		osc.amplitude.setName("Volume");
		
		clock.frequency.setup(0.0, 2.0, 50.0);
		clock.frequency.setName("Sequencer Frequency");
		clock.amplitude.set(1);
		
		//GUI
		
		panel = new JPanel();
		this.add(panel);
		
		BoxLayout layout = new BoxLayout(parent, defaultCloseOperation);
		setLayout(layout);
		
		RotaryTextController[] knobs = new RotaryTextController[NUM_OF_STEPS];
		for (int i = 0; i < NUM_OF_STEPS; i++) {
			DoubleBoundedRangeModel model = PortModelFactory.createExponentialModel(seq.freqs[i]);
			knobs[i] = new RotaryTextController(model, 10);
			knobs[i].setTitle(seq.freqs[i].getName());
			panel.add(knobs[i]);
			knobs[i].setBounds(10 + i * 20, 100, 10, 10);
		}
		
		setupPortKnob(clock.frequency);
		setupPortKnob(osc.amplitude);
		
		JToggleButton[] noteToggleButtons = new JToggleButton[16];
		
		ItemListener toggleButtonClicked = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JToggleButton changedButton = (JToggleButton) e.getItem();
				String buttonText = changedButton.getText();
				if (e.getStateChange() == ItemEvent.SELECTED)  {
					System.out.println("Button " + buttonText + " selected");
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.println("Button " + buttonText + " deselected");
				}
			}
			
		};
		
		for(int i = 0; i < noteToggleButtons.length; i++) {
			noteToggleButtons[i] = new JToggleButton(Integer.toString(i + 1));
			noteToggleButtons[i].addItemListener(toggleButtonClicked);
			noteToggleButtons[i].setBounds(10 + i * 20, 280, 10, 10);
			panel.add(noteToggleButtons[i]);
		}
		
		synth.start();
		lineOut.start();
	}
	
	private RotaryTextController setupPortKnob(UnitInputPort port) {

		DoubleBoundedRangeModel model = PortModelFactory.createExponentialModel(port);
		RotaryTextController knob = new RotaryTextController(model, 10);
		knob.setTitle(port.getName());
		this.add(knob);
		return knob;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		JFrame frame = new Synth();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Synth");
		
		//Get size of monitor in pixels
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenX = screenSize.width;
		int screenY = screenSize.height;
		
		//Set size and location of JFrame
		frame.setSize(sizeX, sizeY);
		frame.setLocation((screenX - sizeX) / 2, (screenY - sizeY) / 2);
		
		frame.setVisible(true);
	}
	
}
