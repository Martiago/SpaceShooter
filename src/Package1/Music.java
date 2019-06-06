package Package1;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;

public class Music {

    private Clip clip;
    private AudioInputStream audioInputStream;
    private static String filePath = "pic/music.wav";
    private BufferedInputStream in;

    public Music() {

        in = new BufferedInputStream(getClass().getResourceAsStream(filePath));

        try {
            audioInputStream = AudioSystem.getAudioInputStream(in);
        } catch (UnsupportedAudioFileException | IOException e) {

            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {

            e.printStackTrace();
        }
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public Clip getClip() {
        return clip;
    }

}