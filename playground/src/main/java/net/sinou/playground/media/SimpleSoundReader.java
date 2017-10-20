package net.sinou.playground.media;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/** Simply read a wav file with javax.sound */
public class SimpleSoundReader {

	public static void main(String[] args) {
		SimpleSoundReader reader = new SimpleSoundReader();
		reader.play();
	}

	public void play() {
		try {
			String baseDir = System.getProperty("user.dir") + "/src/main/resources/sounds/";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(baseDir + "bark.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
