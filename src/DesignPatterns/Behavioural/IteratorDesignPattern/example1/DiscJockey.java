package DesignPatterns.Behavioural.IteratorDesignPattern.example1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DiscJockey {


    SongsOf90s songsOf90s;
    SongsOf2000s songsOf2000s;
    SongsOf2010s songsOf2010s;

    SongsIterator iterator90s;
    SongsIterator iterator2000s;
    SongsIterator iterator2010s;



    public DiscJockey(SongsIterator newSongsOf90s,SongsIterator newSongsOf2000s,SongsIterator newSongsOf2010s){
        iterator90s=newSongsOf90s;
        iterator2000s=newSongsOf2000s;
        iterator2010s=newSongsOf2010s;
    }

    //this is not a recommended way as its very tedious to write code for every collection iteration separately
    //though it works its not a good to read code. hence there was an introduction Iterator design pattern
    //were we introduce a single interface which can be used by client and that interface will be responsible
    // for handling different collections behind the scenes
    public void showTheSongs(){

        ArrayList<SongsInfo> aL90sSongs= songsOf90s.getBestSongs90s();

        System.out.println("Best Songs of 90s \n");

        for(int i=0; i < aL90sSongs.size();i++){
            System.out.println(aL90sSongs.get(i));
        }

        SongsInfo[]  aL2000sSongs=songsOf2000s.getBestSongs2000s();

        System.out.println("\nBest Songs of 2000s \n");
        for (int i=0 ; i < aL2000sSongs.length;i++){
            System.out.println(aL2000sSongs[i]);
        }

        HashMap<Integer,SongsInfo> aL2010sSongs = songsOf2010s.getBestSongs2010s();
        System.out.println("\nBest Songs of 2010s \n");
        for(int i=0 ;  i < aL2010sSongs.size();i++){
            System.out.println(aL2010sSongs.get(i));
        }
    }

    public void showTheSongs2(){

        Iterator songs90s = iterator90s.createIterator();
        Iterator songs2000s = iterator2000s.createIterator();
        Iterator songs2010s = iterator2010s.createIterator();

        System.out.println("Best Songs of 90s \n");
        printTheSongs(songs90s);

        System.out.println("Best Songs of 2000s \n");
        printTheSongs(songs2000s);

        System.out.println("Best Songs of 2010s \n");
        printTheSongs(songs2010s);

    }

    private void printTheSongs(Iterator iterator) {
        while(iterator.hasNext()){

            SongsInfo song = (SongsInfo) iterator.next();
            System.out.println(song);
        }
    }


}
