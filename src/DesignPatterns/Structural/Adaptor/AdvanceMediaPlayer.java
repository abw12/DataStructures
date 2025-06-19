package DesignPatterns.Structural.Adaptor;

// Adaptee class( existing class which need to be used by client code but it's not compatible)
public class AdvanceMediaPlayer {

    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }

}
