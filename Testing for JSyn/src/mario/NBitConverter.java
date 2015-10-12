package mario;

import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitOutputPort;
import com.jsyn.unitgen.UnitGenerator;

public class NBitConverter extends UnitGenerator {
	
	public UnitInputPort input;
	public UnitOutputPort output;
	public UnitInputPort bitRate;
	
	public NBitConverter() {
		addPort(input = new UnitInputPort("Input"));
		addPort(output = new UnitOutputPort("Output"));
		addPort(bitRate = new UnitInputPort("Bit Rate"));
	}
	
	@Override
	public void generate(int start, int limit) {
		double[] inputs = input.getValues();
		double[] outputs = output.getValues();
		double[] bitRates = bitRate.getValues();
		
		for (int i = start; i < limit; i++) {
			outputs[i] = ((int) (inputs[i] * bitRates[i])) * 1.0 / bitRates[i];
		}
	}

}
