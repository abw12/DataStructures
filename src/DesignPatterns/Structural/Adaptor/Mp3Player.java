package DesignPatterns.Structural.Adaptor;

public class Mp3Player extends InterfaceAdaptor{

    @Override
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file: " + fileName);
    }
}
