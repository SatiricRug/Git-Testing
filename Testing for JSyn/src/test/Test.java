package test;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.EnvelopeDAHDSR;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SquareOscillator;
import com.jsyn.unitgen.SquareOscillatorBL;
import com.jsyn.unitgen.TriangleOscillator;
import com.jsyn.unitgen.UnitVoice;
import com.jsyn.util.VoiceAllocator;
import com.softsynth.shared.time.ScheduledCommand;
import com.softsynth.shared.time.TimeStamp;

public class Test {
	
	private static Synthesizer synth;
	private static LineOut lineOut;
	
	private static TriangleOscillator triangleVoice;
	private static VoiceAllocator allocator;
	private static UnitVoice[] voices;
	private static NBitConverter[] bitConverters;
	
	public static final int MAX_VOICES = 8;
	public static final int NUM_OF_BITS = 7;
	
	/** Number of seconds to generate music in advance of presentation-time. */
	private static double advance = 0.2;
	private static double secondsPerBeat = .15;

	public static void main(String[] args) {
		play();
	}
	
	private static void play() {
		synth = JSyn.createSynthesizer();
		
		synth.add(lineOut = new LineOut());
		
		voices = new UnitVoice[MAX_VOICES];
		bitConverters = new NBitConverter[MAX_VOICES];
		
		for(int i = 0; i < MAX_VOICES; i++) {
			SquareOscillatorBL voice = new SquareOscillatorBL();
			voice.noteOff();
			NBitConverter bitConverter = new NBitConverter(NUM_OF_BITS);
			
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
		NBitConverter bitConverter = new NBitConverter(NUM_OF_BITS);
		
		synth.add(triangleVoice);
		synth.add(bitConverter);
		
		triangleVoice.getOutput().connect(bitConverter.input);
		bitConverter.output.connect(0, lineOut.input, 0);
		bitConverter.output.connect(0, lineOut.input, 1);
		
		synth.start(11025);
		lineOut.start();
		
		// Get synthesizer time in seconds.
		double timeNow = synth.getCurrentTime();
		TimeStamp timeStampNow = new TimeStamp(timeNow);
		allocator.noteOff(69, timeStampNow);
		// Advance to a near future time so we have a clean start.
		double time = timeNow + 1.0;
		
		try {
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 50, 66, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 67, 71, 79);
			time += secondsPerBeat * 4;
			
			playNote(time, secondsPerBeat, 55, 67);
			time += secondsPerBeat * 4;
			
			for (int j = 0; j < 2; j++) {
				playNote(time, secondsPerBeat, 55, 64, 72);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 52, 60, 67);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 48, 55, 64);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 53, 60, 69);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 55, 62, 71);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 54, 61, 70);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53, 60, 69);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat * 4 / 3, 52, 60, 67);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 60, 67, 76);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 64, 71, 79);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat, 65, 72, 81);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 62, 69, 77);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 64, 71, 79);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 60, 69, 76);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 57, 64, 72);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 59, 65, 74);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55, 62, 71);
				time += secondsPerBeat * 3;
			}
			for (int i = 0; i < 2; i++) {
				playNote(time, secondsPerBeat, 48);
				time += secondsPerBeat * 2;
	
				playNote(time, secondsPerBeat, 76, 79);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55, 75, 78);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 74, 77);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 71, 75);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 72, 76);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 64, 68);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 65, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60, 67, 72);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 60, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53, 64, 72);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 65, 74);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 48);
				time += secondsPerBeat * 2;
	
				playNote(time, secondsPerBeat, 76, 79);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 52, 75, 78);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 74, 77);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 71, 75);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60, 72, 76);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 77, 79, 84);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 77, 79, 84);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 77, 79, 84);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 48);
				time += secondsPerBeat * 2;
	
				playNote(time, secondsPerBeat, 76, 79);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55, 75, 78);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 74, 77);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 71, 75);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 72, 76);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 64, 68);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 65, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60, 67, 72);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 60, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53, 64, 72);
				time += secondsPerBeat;
	
				playNote(time, secondsPerBeat, 65, 74);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 48);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 56, 68, 75);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 58, 65, 74);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 60, 64, 72);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 48);
				time += secondsPerBeat * 2;
			}
			
			playNote(time, secondsPerBeat, 44, 68, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 68, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 51, 68, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 68, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 56, 70, 74);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 55, 67, 76);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 64, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 48, 64, 69);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 60, 67);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 43);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 44, 68, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 68, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 51, 68, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 68, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 56, 70, 74);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 67, 76);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 55);
			time += secondsPerBeat * 3;
			
			playNote(time, secondsPerBeat, 48);
			time += secondsPerBeat * 3;
			
			playNote(time, secondsPerBeat, 43);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 44, 68, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 68, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 51, 68, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 68, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 56, 70, 74);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 55, 67, 76);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 64, 72);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 48, 64, 69);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 60, 67);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 43);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 50, 66, 72);
			time += secondsPerBeat;
			
			playNote(time, secondsPerBeat, 50, 66, 76);
			time += secondsPerBeat * 2;
			
			playNote(time, secondsPerBeat, 67, 71, 79);
			time += secondsPerBeat * 4;
			
			playNote(time, secondsPerBeat, 55, 67);
			time += secondsPerBeat * 4;
			
			for (int j = 0; j < 2; j++) {
				playNote(time, secondsPerBeat, 55, 64, 72);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 52, 60, 67);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 48, 55, 64);
				time += secondsPerBeat * 3;
				
				playNote(time, secondsPerBeat, 53, 60, 69);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 55, 62, 71);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 54, 61, 70);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53, 60, 69);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat * 4 / 3, 52, 60, 67);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 60, 67, 76);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 64, 71, 79);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat, 65, 72, 81);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 62, 69, 77);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 64, 71, 79);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 60, 69, 76);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 57, 64, 72);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 59, 65, 74);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55, 62, 71);
				time += secondsPerBeat * 3;
			}
			
			for (int i = 0; i < 2; i++) {
				playNote(time, secondsPerBeat, 48, 72, 76);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 69, 72);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 54, 64, 67);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 60, 64, 68);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 53, 65, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 72, 77);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 72, 77);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60, 65, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 50);
				playNote(time, secondsPerBeat * 4 / 3, 67, 71);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat, 77, 81);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat, 77, 81);
				time += secondsPerBeat / 3;
				
				playNote(time, secondsPerBeat, 53);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55);
				playNote(time, secondsPerBeat * 4 / 3, 77, 81);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 76, 79);
				time += secondsPerBeat * 2 / 3;
				
				playNote(time, secondsPerBeat, 59);
				time += secondsPerBeat * 2 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 74, 77);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat, 57, 72, 76);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 69, 72);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 57);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 65, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60, 64, 67);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 48, 72, 76);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 69, 72);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 54, 64, 67);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 60, 64, 68);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 53, 65, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 72, 77);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 72, 77);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60, 65, 69);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 60);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 53);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 55, 67, 71);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 74, 77);
				time += secondsPerBeat * 2;
				
				playNote(time, secondsPerBeat, 55, 74, 77);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat * 4 / 3, 55, 74, 77);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 57, 72, 76);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat * 4 / 3, 59, 71, 74);
				time += secondsPerBeat * 4 / 3;
				
				playNote(time, secondsPerBeat, 60, 67, 72);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 64);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 55);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 64);
				time += secondsPerBeat;
				
				playNote(time, secondsPerBeat, 48, 60);
				time += secondsPerBeat * 4;
			}
		} catch (InterruptedException e) {
			System.out.println("What the fuck?");
			e.printStackTrace();
		} finally {
			synth.stop();
		}
	}
	
	private static void playNote(double time, double dur, int note1, int note2, int note3) throws InterruptedException {
		catchUp(time);
		
		triangleVoice.noteOn(time, note1);
		noteOn(time, note2);
		noteOn(time, note3);
		
		double offTime = time + dur / 2;
		
		triangleVoice.noteOff(offTime, note1);
		noteOff(offTime, note2);
		noteOff(offTime, note3);
	}
	
	private static void playNote(double time, double dur, int note1, int note2) throws InterruptedException {
		catchUp(time);
		
		noteOn(time, note1);
		noteOn(time, note2);
		
		double offTime = time + dur / 2;
		
		noteOff(offTime, note1);
		noteOff(offTime, note2);
	}
	
	private static void playNote(double time, double dur, int note1) throws InterruptedException {
		catchUp(time);
		
		noteOn(time, note1);
		
		double offTime = time + dur / 1.15;
		
		noteOff(offTime, note1);
	}
	
	public static double convertPitchToFreq(double pitch) {
		return 440.0 * Math.pow(2.0, ((pitch - 69) * (1.0 / 12.0)));
	}
	
	private static void catchUp(double time) throws InterruptedException {
		synth.sleepUntil(time - advance);
	}

	private static void noteOff(double time, int noteNumber) {
		allocator.noteOff(noteNumber, new TimeStamp(time));
	}

	private static void noteOn(double time, int noteNumber) {
		double frequency = convertPitchToFreq(noteNumber);
		double amplitude = 0.5;
		TimeStamp timeStamp = new TimeStamp(time);
		allocator.noteOn(noteNumber, frequency, amplitude, timeStamp);
	}
	
	private static void triangleNoteOff(TimeStamp timeStamp) {
		
	}
	
}
