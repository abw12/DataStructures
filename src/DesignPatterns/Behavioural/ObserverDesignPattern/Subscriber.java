package DesignPatterns.Behavioural.ObserverDesignPattern;

public class Subscriber implements Observer {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject channel){
        System.out.println("Hey " + name + " , new video is uploaded : title - " + channel.getTitle());
    }

}
