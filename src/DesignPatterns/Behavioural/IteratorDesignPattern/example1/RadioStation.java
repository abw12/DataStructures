package DesignPatterns.Behavioural.IteratorDesignPattern.example1;

public class RadioStation {

    public static void main(String[] args) {

        SongsOf90s songsOf90s = new SongsOf90s() ;
        SongsOf2000s songsOf2000s = new SongsOf2000s();
        SongsOf2010s songsOf2010s=new SongsOf2010s();

        DiscJockey rjRavi = new DiscJockey(songsOf90s,songsOf2000s,songsOf2010s);
        rjRavi.showTheSongs2();

    }
}
