package DesignPatterns.Behavioural.ObserverDesignPattern;

//observer design pattern is the best example of how the youtube push notification works in real world
//the channel in the below example is termed as subject
//and the subscriber is termed as observer
//so any change in subject gets notified to the observer
//to implement the subject and the observer we can introduce an interface known as subject and observer to define the abstract methods
public class Youtube {

    public static void main(String[] args) {

        Subject TSeries = new Channel();

        //creating an obj for all the unique subscribers(people)
        Observer s1 = new Subscriber("Abhishek");
        Observer s2 = new Subscriber("Vedant");
        Observer s3 = new Subscriber("Raki");
        Observer s4 = new Subscriber("Sarang");

        //this is channel to subscriber meaning TSeries is being subscribed by these  many ppl
        TSeries.subscribe(s1);
        TSeries.subscribe(s2);
        TSeries.subscribe(s3);
        TSeries.subscribe(s4);

        //suppose s2 wants to unsubscribe to TSeries Channel
        TSeries.unsubsribe(s2);

        //here we are uploading a new video
        TSeries.upload("Sumsheera Title Track");

    }
}
