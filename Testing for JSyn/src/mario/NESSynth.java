package mario;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SquareOscillatorBL;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitVoice;
import com.jsyn.util.VoiceAllocator;
import com.softsynth.shared.time.TimeStamp;
/**
 * A class that emulates the soud capabilities of the Nintendo Entertainment System (NES).
 */
public class NESSynth {
	
	private Synthesizer synth;
	private LineOut lineOut;
	
	private TriangleOscillator triangleVoice;
	private VoiceAllocator allocator;
	private UnitVoice[] voices;
	
	public final int MAX_VOICES = 2;
	public final int BIT_RATE = 4;
	
	/** Number of seconds to generate music in advance of presentation-time. */
	private double advance = 0.2;
	
	/** The time of generation. */
	private double time;
	
	public NESSynth() {
		synth = JSyn.createSynthesizer();
		
		synth.add(lineOut = new LineOut());
		
		voices = new UnitVoice[MAX_VOICES];
		
		for(int i = 0; i < MAX_VOICES; i++) {
			SquareOscillatorBL voice = new SquareOscillatorBL();
			voice.noteOff();
			NBitConverter bitConverter = new NBitConverter();
			
			synth.add(voice);
			synth.add(bitConverter);
			
			voice.getOutput().connect(bitConverter.input);
			bitConverter.output.connect(0, lineOut.input, 0);
			bitConverter.output.connect(0, lineOut.input, 1);
			
			voices[i] = voice;
		}
		allocator = new VoiceAllocator(voices);
		
		triangleVoice = new TriangleOscillator();
		triangleVoice.noteOff();
		NBitConverter bitConverter = new NBitConverter();
		
		synth.add(triangleVoice);
		synth.add(bitConverter);
		
		triangleVoice.getOutput().connect(bitConverter.input);
		bitConverter.output.connect(0, lineOut.input, 0);
		bitConverter.output.connect(0, lineOut.input, 1);
		
		bitConverter.bitRate.set(BIT_RATE);
		
		synth.start(48000);
		lineOut.start();
		
		// Get synthesizer time in seconds.
		double timeNow = synth.getCurrentTime();
		TimeStamp timeStampNow = new TimeStamp(timeNow);
		allocator.noteOff(69, timeStampNow);
		// Advance to a near future time so we have a clean start.
		time = timeNow + 1.0;
	}
	
	/**
	 * Stops the synth.
	 */
	public void stop() {
		synth.stop();
	}
	
	public double getGeneratorTime() {
		return time;
	}
	
	public void addTime(double addTime) {
		this.time += addTime;
	}
	
	public void playNote(double dur, int note1, int note2, int note3) throws InterruptedException {
		catchUp(time);
		
		triNoteOn(time, note1);
		noteOn(time, note2);
		noteOn(time, note3);
		
		double offTime = time + dur / 2;
		
		triNoteOff(offTime);
		noteOff(offTime, note2);
		noteOff(offTime, note3);
	}
	
	public void playNote(double dur, int note1, int note2) throws InterruptedException {
		catchUp(time);
		
		noteOn(time, note1);
		noteOn(time, note2);
		
		double offTime = time + dur / 2;
		
		noteOff(offTime, note1);
		noteOff(offTime, note2);
	}
	
	public void playNote(double dur, int note1) throws InterruptedException {
		catchUp(time);
		
		triNoteOn(time, note1);
		
		double offTime = time + dur / 1.15;
		
		triNoteOff(offTime);
	}
	
	public double convertPitchToFreq(double pitch) {
		return 440.0 * Math.pow(2.0, ((pitch - 69) * (1.0 / 12.0)));
	}
	
	public void catchUp(double time) throws InterruptedException {
		synth.sleepUntil(time - advance);
	}

	private void noteOff(double time, int noteNumber) {
		allocator.noteOff(noteNumber, new TimeStamp(time));
	}

	private void noteOn(double time, int noteNumber) {
		double frequency = convertPitchToFreq(noteNumber);
		double amplitude = 0.5;
		TimeStamp timeStamp = new TimeStamp(time);
		allocator.noteOn(noteNumber, frequency, amplitude, timeStamp);
	}
	
	private void triNoteOff(double time) {
		triangleVoice.noteOff(new TimeStamp(time));
	}
	
	private void triNoteOn(double time, int noteNumber) {
		double frequency = convertPitchToFreq(noteNumber);
		double amplitude = 0.5;
		TimeStamp timeStamp = new TimeStamp(time);
		triangleVoice.noteOn(frequency, amplitude, timeStamp);
	}
	
}
