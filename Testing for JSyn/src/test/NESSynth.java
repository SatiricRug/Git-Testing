package test;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.EnvelopeDAHDSR;
import com.jsyn.unitgen.FilterLowPass;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SquareOscillatorBL;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitVoice;
import com.jsyn.util.VoiceAllocator;
import com.softsynth.jsyn.Synth;
import com.softsynth.shared.time.TimeStamp;

public class NESSynth {
	
	private Synthesizer synth;
	private LineOut lineOut;
	
	private TriangleOscillator triangleVoice;
	private VoiceAllocator allocator;
	private UnitVoice[] voices;
	private NBitConverter[] bitConverters;
	private FilterLowPass lowPassFilter;
	
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
		FilterLowPass filter = new FilterLowPass();
		
		synth.add(triangleVoice);
		synth.add(bitConverter);
		
		triangleVoice.getOutput().connect(bitConverter.input);
		bitConverter.output.connect(0, lineOut.input, 0);
		bitConverter.output.connect(0, lineOut.input, 1);
		
		bitConverter.bitRate.set(BIT_RATE);
		
		synth.start(11025);
		lineOut.start();
		
		// Get synthesizer time in seconds.
		TimeStamp timeStampNow = getCurrentTimeStamp();
		allocator.noteOff(69, timeStampNow);
		// Advance to a near future time so we have a clean start.
		time = getCurrentTimeDouble() + 1.0;
	}
	
	/**
	 * Stops the synth.
	 */
	public void stop() {
		synth.stop();
	}
	
	/**
	 * @return the current synthesizer time as a TimeStamp
	 */
	public TimeStamp getCurrentTimeStamp() {
		return new TimeStamp(synth.getCurrentTime());
	}
	
	public double getCurrentTimeDouble() {
		return synth.getCurrentTime();
	}
	
	public double getGeneratorTime() {
		return time;
	}
	
	public void addTime(double time) {
		this.time += time;
	}
	
	public void playNote(double dur, int note1, int note2, int note3) throws InterruptedException {
		catchUp(time);
		
		TimeStamp timeStamp = new TimeStamp(time);
		triNoteOn(timeStamp, note1);
		noteOn(timeStamp, note2);
		noteOn(timeStamp, note3);
		
		double offTime = time + dur / 2;
		
		TimeStamp offTimeStamp = new TimeStamp(offTime);
		triangleVoice.noteOff(offTimeStamp);
		noteOff(offTimeStamp, note2);
		noteOff(offTimeStamp, note3);
	}
	
	public void playNote(double dur, int note1, int note2) throws InterruptedException {
		catchUp(time);
		
		TimeStamp timeStamp = new TimeStamp(time);
		noteOn(timeStamp, note1);
		noteOn(timeStamp, note2);
		
		double offTime = time + dur / 2;
		
		TimeStamp offTimeStamp = new TimeStamp(offTime);
		noteOff(offTimeStamp, note1);
		noteOff(offTimeStamp, note2);
	}
	
	public void playNote(double dur, int note1) throws InterruptedException {
		catchUp(time);
		
		TimeStamp timeStamp = new TimeStamp(time);
		triNoteOn(timeStamp, note1);
		
		double offTime = time + dur / 1.15;
		
		TimeStamp offTimeStamp = new TimeStamp(offTime);
		triangleVoice.noteOff(offTimeStamp);
	}
	
	public double convertPitchToFreq(double pitch) {
		return 440.0 * Math.pow(2.0, ((pitch - 69) * (1.0 / 12.0)));
	}
	
	public void catchUp(double time) throws InterruptedException {
		synth.sleepUntil(time - advance);
	}

	private void noteOff(TimeStamp timeStamp, int noteNumber) {
		allocator.noteOff(noteNumber, timeStamp);
	}

	private void noteOn(TimeStamp timeStamp, int noteNumber) {
		double frequency = convertPitchToFreq(noteNumber);
		double amplitude = 0.5;
		allocator.noteOn(noteNumber, frequency, amplitude, timeStamp);
	}
	
	private void triNoteOn(TimeStamp timeStamp, int noteNumber) {
		double frequency = convertPitchToFreq(noteNumber);
		double amplitude = 0.5;
		triangleVoice.noteOn(frequency, amplitude, timeStamp);
	}
	
}
