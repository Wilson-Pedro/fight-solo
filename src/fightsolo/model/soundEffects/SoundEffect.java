package fightsolo.model.soundEffects;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {
	
	public static final String PATH = "soundEffects\\";
	
	public SoundEffect() {
	}
	
	public void play(String pathForSoundEffect) {
		try {
			File musicPath = new File(pathForSoundEffect);
			
			if(musicPath.exists()) {
				
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
			}
		} catch(Exception e) {
			System.out.println("Sound Effect Error: " + e);
		}
	}
	
	public void playAttackSound() {
		play(PATH + "sound-attack.wav");
	}
}
