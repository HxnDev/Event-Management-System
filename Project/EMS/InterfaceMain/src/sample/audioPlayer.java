package sample;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class audioPlayer {

    private static String musicFile = "src/sample/audio/test.wav";

    // to store current position
    Long currentFrame;
    private static Clip clip;

    // current status of clip
    private static String status;

    private static AudioInputStream audioInputStream;

    // constructor to initialize streams and clip
    public static void init() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(musicFile).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);
    }

    public static void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //start the clip
        init();
        clip.start();
        status = "play";
    }
}
