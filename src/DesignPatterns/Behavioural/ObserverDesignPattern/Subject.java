package DesignPatterns.Behavioural.ObserverDesignPattern;

public interface Subject {
    String getTitle();

    void subscribe(Observer sub);

    void unsubsribe(Observer sub);

    void notifySubscribers();

    //uploading a new video on channel with the title
    void upload(String title);
}
