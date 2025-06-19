package DesignPatterns.Structural.Adaptor;

//Class Adaptor implementation
public class ClassAdaptor extends AdvanceMediaPlayer implements MediaPlayer{


    @Override
    public void play(String audiotype, String fileName) {
        if (audiotype.equalsIgnoreCase("vlc")) {
            playVlc(fileName);
        } else if (audiotype.equalsIgnoreCase("mp4")) {
            playMp4(fileName);
        }
    }
}
