package test;

public class Test {
	
	private static NESSynth synth;
	
	private static double secondsPerBeat = .15;

	public static void main(String[] args) throws InterruptedException {
		play();
	}
	
	private static void play() throws InterruptedException {
		synth = new NESSynth();
		
		try {
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 50, 66, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 67, 71, 79);
			synth.addTime(secondsPerBeat * 4);
			
			synth.playNote(secondsPerBeat, 55, 67);
			synth.addTime(secondsPerBeat * 4);
			
			for (int j = 0; j < 2; j++) {
				synth.playNote(secondsPerBeat, 55, 64, 72);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 52, 60, 67);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 48, 55, 64);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 53, 60, 69);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 55, 62, 71);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 54, 61, 70);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53, 60, 69);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat * 4 / 3, 52, 60, 67);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 60, 67, 76);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 64, 71, 79);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat, 65, 72, 81);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 62, 69, 77);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 64, 71, 79);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 60, 69, 76);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 57, 64, 72);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 59, 65, 74);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55, 62, 71);
				synth.addTime(secondsPerBeat * 3);
			}
			for (int i = 0; i < 2; i++) {
				synth.playNote(secondsPerBeat, 48);
				synth.addTime(secondsPerBeat * 2);
	
				synth.playNote(secondsPerBeat, 76, 79);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55, 75, 78);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 74, 77);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 71, 75);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 72, 76);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 64, 68);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 65, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60, 67, 72);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 60, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53, 64, 72);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 65, 74);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 48);
				synth.addTime(secondsPerBeat * 2);
	
				synth.playNote(secondsPerBeat, 76, 79);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 52, 75, 78);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 74, 77);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 71, 75);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60, 72, 76);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 77, 79, 84);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 77, 79, 84);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 77, 79, 84);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 48);
				synth.addTime(secondsPerBeat * 2);
	
				synth.playNote(secondsPerBeat, 76, 79);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55, 75, 78);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 74, 77);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 71, 75);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 72, 76);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 64, 68);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 65, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60, 67, 72);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 60, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53, 64, 72);
				synth.addTime(secondsPerBeat);
	
				synth.playNote(secondsPerBeat, 65, 74);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 48);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 56, 68, 75);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 58, 65, 74);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 60, 64, 72);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 48);
				synth.addTime(secondsPerBeat * 2);
			}
			
			synth.playNote(secondsPerBeat, 44, 68, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 68, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 51, 68, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 68, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 56, 70, 74);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 55, 67, 76);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 64, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 48, 64, 69);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 60, 67);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 43);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 44, 68, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 68, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 51, 68, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 68, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 56, 70, 74);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 67, 76);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 55);
			synth.addTime(secondsPerBeat * 3);
			
			synth.playNote(secondsPerBeat, 48);
			synth.addTime(secondsPerBeat * 3);
			
			synth.playNote(secondsPerBeat, 43);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 44, 68, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 68, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 51, 68, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 68, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 56, 70, 74);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 55, 67, 76);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 64, 72);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 48, 64, 69);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 60, 67);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 43);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 50, 66, 72);
			synth.addTime(secondsPerBeat);
			
			synth.playNote(secondsPerBeat, 50, 66, 76);
			synth.addTime(secondsPerBeat * 2);
			
			synth.playNote(secondsPerBeat, 67, 71, 79);
			synth.addTime(secondsPerBeat * 4);
			
			synth.playNote(secondsPerBeat, 55, 67);
			synth.addTime(secondsPerBeat * 4);
			
			for (int j = 0; j < 2; j++) {
				synth.playNote(secondsPerBeat, 55, 64, 72);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 52, 60, 67);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 48, 55, 64);
				synth.addTime(secondsPerBeat * 3);
				
				synth.playNote(secondsPerBeat, 53, 60, 69);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 55, 62, 71);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 54, 61, 70);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53, 60, 69);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat * 4 / 3, 52, 60, 67);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 60, 67, 76);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 64, 71, 79);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat, 65, 72, 81);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 62, 69, 77);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 64, 71, 79);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 60, 69, 76);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 57, 64, 72);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 59, 65, 74);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55, 62, 71);
				synth.addTime(secondsPerBeat * 3);
			}
			
			for (int i = 0; i < 2; i++) {
				synth.playNote(secondsPerBeat, 48, 72, 76);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 69, 72);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 54, 64, 67);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 60, 64, 68);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 53, 65, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 72, 77);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 72, 77);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60, 65, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 50);
				synth.playNote(secondsPerBeat * 4 / 3, 67, 71);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat, 77, 81);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat, 77, 81);
				synth.addTime(secondsPerBeat / 3);
				
				synth.playNote(secondsPerBeat, 53);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55);
				synth.playNote(secondsPerBeat * 4 / 3, 77, 81);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 76, 79);
				synth.addTime(secondsPerBeat * 2 / 3);
				
				synth.playNote(secondsPerBeat, 59);
				synth.addTime(secondsPerBeat * 2 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 74, 77);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat, 57, 72, 76);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 69, 72);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 57);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 65, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60, 64, 67);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 48, 72, 76);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 69, 72);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 54, 64, 67);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 60, 64, 68);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 53, 65, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 72, 77);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 72, 77);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60, 65, 69);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 60);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 53);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 55, 67, 71);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 74, 77);
				synth.addTime(secondsPerBeat * 2);
				
				synth.playNote(secondsPerBeat, 55, 74, 77);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat * 4 / 3, 55, 74, 77);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 57, 72, 76);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat * 4 / 3, 59, 71, 74);
				synth.addTime(secondsPerBeat * 4 / 3);
				
				synth.playNote(secondsPerBeat, 60, 67, 72);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 64);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 55);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 64);
				synth.addTime(secondsPerBeat);
				
				synth.playNote(secondsPerBeat, 48, 60);
				synth.addTime(secondsPerBeat * 4);
			}
		} catch (InterruptedException e) {
			System.out.println("What the fuck?");
			e.printStackTrace();
		} finally {
			
			synth.catchUp(synth.getGeneratorTime() + 2);
			System.out.println("just in case...");
			synth.stop();
		}
	}
	
//	private static void .playNote(double time, double dur, int note1, int note2, int note3) throws InterruptedException {
//		catchUp(time);
//		
//		triangleVoice.noteOn(time, note1);
//		noteOn(time, note2);
//		noteOn(time, note3);
//		
//		double offTime = time + dur / 2;
//		
//		triangleNoteOff(offTime);
//		noteOff(offTime, note2);
//		noteOff(offTime, note3);
//	}
//	
//	private static void playNote(double time, double dur, int note1, int note2) throws InterruptedException {
//		catchUp(time);
//		
//		noteOn(time, note1);
//		noteOn(time, note2);
//		
//		double offTime = time + dur / 2;
//		
//		noteOff(offTime, note1);
//		noteOff(offTime, note2);
//	}
//	
//	private static void playNote(double time, double dur, int note1) throws InterruptedException {
//		catchUp(time);
//		
//		triangleVoice.noteOn(time, note1);
//		
//		double offTime = time + dur / 1.15;
//		TimeStamp offTimeStamp = new TimeStamp(offTime);
//		triangleVoice.noteOff(offTimeStamp);
//	}
//	
//	public static double convertPitchToFreq(double pitch) {
//		return 440.0 * Math.pow(2.0, ((pitch - 69) * (1.0 / 12.0)));
//	}
//	
//	private static void catchUp(double time) throws InterruptedException {
//		synth.sleepUntil(time - advance);
//	}
//
//	private static void noteOff(double time, int noteNumber) {
//		allocator.noteOff(noteNumber, new TimeStamp(time));
//	}
//
//	private static void noteOn(double time, int noteNumber) {
//		double frequency = convertPitchToFreq(noteNumber);
//		double amplitude = 0.5;
//		TimeStamp timeStamp = new TimeStamp(time);
//		allocator.noteOn(noteNumber, frequency, amplitude, timeStamp);
//	}
//	
//	private static void triNoteOn(double time, int noteNumber) {
//		double frequency = convertPitchToFreq(noteNumber);
//		double amplitude = 0.5;
//		TimeStamp timeStamp = new TimeStamp(time);
//		triangleVoice.noteOn(frequency, amplitude, timeStamp);
//	}
//	
}
