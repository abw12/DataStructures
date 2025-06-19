package DesignPatterns.Behavioural.IteratorDesignPattern.example1;

public class SongsInfo {

    private String songName;
    private String album;
    private int yearOfRelease;

    public SongsInfo(String songName, String album, int yearOfRelease) {
        this.songName = songName;
        this.album = album;
        this.yearOfRelease = yearOfRelease;
    }

    public String getSongName() {
        return songName;
    }

    public String getAlbum() {
        return album;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    @Override
    public String toString() {
        return
                "songName='" + songName + '\'' +
                ", album='" + album + '\'' +
                ", yearOfRelease=" + yearOfRelease ;
    }
}
