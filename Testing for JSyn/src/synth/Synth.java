package synth;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.ports.UnitInputPort;
import com.jsyn.swing.DoubleBoundedRangeModel;
import com.jsyn.swing.PortModelFactory;
import com.jsyn.swing.RotaryTextController;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SineOscillator;

public class Synth extends JFrame {
	
	JPanel;
	
	private static final long serialVersionUID = 1L;
	private Synthesizer synth;
	
	public Synth() {
		synth = JSyn.createSynthesizer();
		LineOut lineOut = new LineOut();
		SineOscillator osc = new SineOscillator();
		
		synth.add(lineOut);
		synth.add(osc);
		
		osc.getOutput().connect(0, lineOut.input, 0);
		osc.getOutput().connect(0, lineOut.input, 1);
		
		osc.frequency.setup( 50.0, 440.0, 2000.0 );
		osc.frequency.setName("Frequency");
		
		osc.amplitude.setup(0, .5, 1);
		osc.amplitude.setName("Volume");
		
		setLayout(new GridLayout(1, 0));

		setupPortKnob(osc.frequency);
		setupPortKnob(osc.amplitude);
		
		JToggleButton[] noteToggleButtons = new JToggleButton[16];
		
		ItemListener toggleButtonClicked = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)  {
					
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					
				}
			}
			
		};
		
		for(int i = 0; i < noteToggleButtons.length; i++) {
			noteToggleButtons[i] = new JToggleButton(Integer.toString(i));
			noteToggleButtons[i].addItemListener(toggleButtonClicked);
			noteToggleButtons[i].setBounds(10 + i * 20, 280, 10, 10);
			add(noteToggleButtons[i]);
		}
		
		synth.start();
		lineOut.start();
	}
	
	private void setupPortKnob(UnitInputPort port) {

		DoubleBoundedRangeModel model = PortModelFactory.createExponentialModel(port);
		RotaryTextController knob = new RotaryTextController(model, 10);
		knob.setBorder( BorderFactory.createTitledBorder(port.getName()));
		knob.setTitle(port.getName());
		//add(knob);
	}
	
	public static void main(String[] args) {
		JFrame frame = new Synth();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Synth");
		frame.setSize(340, 300);
		frame.setLocation(710, 350);
		frame.setVisible(true);
	}
	
}
