package DesignPatterns.Behavioural.IteratorDesignPattern.example1;

import java.util.HashMap;
import java.util.Iterator;

public class SongsOf2010s implements SongsIterator{

    HashMap<Integer,SongsInfo> bestSongs2010s;

    int hashKey=0;

    public SongsOf2010s(){
        bestSongs2010s=new HashMap<>();

        addSongs("Socha Hai","Rock On!",2010);
        addSongs("Kun Faya Kun!","Rockstar",2011);
        addSongs("Agar Tum Sath Ho","Tamasha",2015);
    }

    public void addSongs(String name,String albumName,int yearOfRelease){

        SongsInfo song = new SongsInfo(name,albumName,yearOfRelease);

        bestSongs2010s.put(hashKey,song);
        hashKey++;
    }

    public HashMap<Integer,SongsInfo> getBestSongs2010s(){
        return bestSongs2010s;
    }

    //using the iterator instead of returning the hashmap directly
    public Iterator createIterator() {
        return bestSongs2010s.values().iterator();
    }
}
