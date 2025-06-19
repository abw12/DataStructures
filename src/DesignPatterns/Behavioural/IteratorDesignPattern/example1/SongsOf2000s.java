package DesignPatterns.Behavioural.IteratorDesignPattern.example1;

import java.util.Arrays;
import java.util.Iterator;

public class SongsOf2000s implements SongsIterator{

    SongsInfo[] bestSongs2000s;

    int i=0;

    public SongsOf2000s(){
        bestSongs2000s=new SongsInfo[3];

        addSongs("Koi Kahe","Dil Chahta Hai",2000);
        addSongs("Na Tum Jano na Jum","Kaho na Pyaar hai",2000);
        addSongs("Main Aysa Kyu Hoon","Lakshya",2004);
    }

    public void addSongs(String name,String albumName,int yearOfRelease){

        SongsInfo song = new SongsInfo(name,albumName,yearOfRelease);
        bestSongs2000s[i]=song;
        i++;

    }

    public SongsInfo[] getBestSongs2000s(){
        return bestSongs2000s;
    }


    //using the iterator instead of returing the array
    public Iterator createIterator() {
        return Arrays.asList(bestSongs2000s).iterator();
    }
}
