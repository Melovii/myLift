package data;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class sound {
    Clip clip;
    FloatControl fc;
    boolean mute = false;
    float previousVol;
    float currentVol;
    URL soundURL[] = new URL[5];

    public sound() {
        soundURL[0] = getClass().getResource("/resources/sounds/complete.wav");
    }

    public void setFile(int i) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }catch(Exception e) {
        }
    }

    public void play(){
        clip.start();
        currentVol = -10.0f;
        fc.setValue(currentVol);
    }
}

