package DesignPatterns.Structural.Adaptor;

//Object Adaptor class ( uses composition )
public class ObjectAdaptor implements MediaPlayer{

    private AdvanceMediaPlayer adaptee; //Ref of the adaptee class object ( composition)

    public ObjectAdaptor(String audioType){   //can directly pass the different adaptee classes as a argument in the constructor
        if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            adaptee = new AdvanceMediaPlayer();
        }
    }

    @Override
    public void play(String audiotype, String fileName) {
        if (audiotype.equalsIgnoreCase("vlc")) {
            adaptee.playVlc(fileName);
        } else if (audiotype.equalsIgnoreCase("mp4")) {
            adaptee.playMp4(fileName);
        }
    }
}
