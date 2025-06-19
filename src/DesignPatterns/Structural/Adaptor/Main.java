package DesignPatterns.Structural.Adaptor;

//client code
public class Main {

    public static void main(String[] args) {
        MediaPlayer player1 = new ClassAdaptor();
        player1.play("vlc", "movie.vlc");
        player1.play("mp4", "video.mp4");

        System.out.println("****************************");

        MediaPlayer player2 = new ObjectAdaptor("vlc");
        player2.play("vlc","movie.vlc");

        player2 = new ObjectAdaptor("mp4");
        player2.play("mp4","video.mp4");

        MediaPlayer player3 = new ObjectAdaptor("mp4"); //Not supported format
        player3.play("png","movie.png");

        System.out.println("****************************");

        AnotherPlayer anotherPlayer = new Mp3Player();
        anotherPlayer.playMp3("song.mp3");
    }
}
