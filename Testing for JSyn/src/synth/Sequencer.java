package synth;

import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitOutputPort;
import com.jsyn.unitgen.UnitGenerator;
import com.jsyn.unitgen.UnitSource;

public class Sequencer extends UnitGenerator implements UnitSource {
	
	public UnitInputPort[] freqs;
	public UnitInputPort clock;
	public UnitOutputPort output;
	
	public static final double DEFAULT_FREQUENCY = 440.0;
	/** What step the sequencer is currently at. */
	public int step;
	public int numOfSteps;
	
	public Sequencer(int numOfSteps) {
		step = 0;
		this.numOfSteps = numOfSteps;
		
		freqs = new UnitInputPort[numOfSteps];
		
		for (int i = 0; i < numOfSteps; i++) {
			freqs[i] = new UnitInputPort("Freq " + i);
			addPort(freqs[i]);
			freqs[i].setup(40.0, DEFAULT_FREQUENCY, 8000.0);
		}
		
		clock = new UnitInputPort("Clock");
		addPort(clock);
		
		output = new UnitOutputPort("Output");
		addPort(output);
	}
	
	@Override
	public void generate(int start, int limit) {
		double[][] frequencies = new double[numOfSteps][];
		double[] outputs = output.getValues();
		double[] clocks = clock.getValues();
		
		for (int i = 0; i < numOfSteps; i++) {
			frequencies[i] = freqs[i].getValues();
		}
		
		for (int i = start; i < limit; i++) {
			for (int j = 0; j < numOfSteps; j++) {
				outputs[i] = frequencies[step][i];
			}
			if (clocks[i] == 1) {
				step++;
			}
			if (step == numOfSteps) {
				step = 0;
			}
		}
		
		
	}
	
	@Override
	public UnitOutputPort getOutput() {
		return output;
	}
	
}
