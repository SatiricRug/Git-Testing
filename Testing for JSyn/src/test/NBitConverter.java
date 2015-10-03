package test;

import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitOutputPort;
import com.jsyn.unitgen.UnitGenerator;

public class NBitConverter extends UnitGenerator {
	
	public UnitInputPort input;
	public UnitOutputPort output;
	public int numOfBits;
	
	public NBitConverter(int numOfBits) {
		addPort(input = new UnitInputPort("Input"));
		addPort(output = new UnitOutputPort("Output"));
		this.numOfBits = numOfBits;
	}
	
	@Override
	public void generate(int start, int limit) {
		double[] inputs = input.getValues();
		double[] outputs = output.getValues();
		
		for (int i = start; i < limit; i++) {
			outputs[i] = ((int) (inputs[i] * numOfBits)) * 1.0 / numOfBits;
		}
	}

}
