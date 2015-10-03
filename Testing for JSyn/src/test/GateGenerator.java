package test;

import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitOutputPort;
import com.jsyn.unitgen.UnitGenerator;
import com.jsyn.unitgen.UnitSource;
import com.softsynth.shared.time.TimeStamp;

/**
 * Generates a binary gate signal.
 *
 */
public class GateGenerator extends UnitGenerator implements UnitSource {
	
	public UnitInputPort amplitude;
	public UnitOutputPort output;
	
	public final double DEFAULT_AMPLITUDE = 1.0;
	
	public GateGenerator() {
		addPort(amplitude = new UnitInputPort("Amplitude", DEFAULT_AMPLITUDE));
		addPort(output = new UnitOutputPort("Output"));
	}
	
	@Override
	public void generate(int start, int limit) {
		double[] amplitudes = amplitude.getValues();
		double[] outputs = output.getValues();
		
		for (int i = start; i < limit; i++) {
			outputs[i] = amplitudes[i];
		}
	}
	
	@Override
	public UnitOutputPort getOutput() {
		return output;
	}
	
	public void noteOff(TimeStamp timeStamp) {
		amplitude.set(0.0, timeStamp);
	}
	
	public void noteOff() {
		amplitude.set(0.0);
	}
	
	public void noteOn(TimeStamp timeStamp) {
		amplitude.set(DEFAULT_AMPLITUDE, timeStamp);
	}
	
	public void noteOn() {
		amplitude.set(DEFAULT_AMPLITUDE);
	}
	
}
