package data;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class sound {
    Clip clip;
    URL soundURL[] = new URL[5];

    public sound() {
        soundURL[0] = getClass().getResource("complete.wav");
    }

    public void setFile(int i) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e) {
        }
    }

    public void play(){
        clip.start();
    }
}
