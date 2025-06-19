package DesignPatterns.Behavioural.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

//channel is your single entity which can have multiple subscribers
//here we are considering only one channel for the example suppose tseries
public class Channel implements Subject {

    private List<Observer> observers = new ArrayList<>(); //list of observers maintained
    private String title;

    @Override
    public String getTitle(){
        return this.title;
    }


    @Override
    public void subscribe(Observer sub){
        observers.add(sub);
    }

    @Override
    public void unsubsribe(Observer sub){
        observers.remove(sub);
    }

    @Override
    public void notifySubscribers(){
        for( Observer sub : observers){
                sub.update(this);
        }
    }
    //uploading a new video on channel with the title
    @Override
    public void upload(String title){
        this.title=title;
        notifySubscribers();
    }
}
