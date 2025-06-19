package DesignPatterns.Behavioural.IteratorDesignPattern.example1;

import java.util.*;


// concrete aggregate classes
public class SongsOf90s implements SongsIterator{

    ArrayList<SongsInfo> bestSongs90s;

    public SongsOf90s(){
        bestSongs90s=new ArrayList<>();

        addSongs("Jhoka Hawa Ka","Hum Dil De Chuke Sanam",1997);
        addSongs("Koyal Si Teri Boli","Beta",1993);
        addSongs("Honton Pe Bas","Yeah Dillagi",1996);

    }

    public void addSongs(String name,String albumName,int yearOfRelease){

        SongsInfo song = new SongsInfo(name,albumName,yearOfRelease);

        bestSongs90s.add(song);
    }


    public ArrayList<SongsInfo> getBestSongs90s(){
        return bestSongs90s;
    }

    //using the iterator instead of directly returning the arrayList
    public Iterator createIterator() {
        return bestSongs90s.iterator();
    }
}
