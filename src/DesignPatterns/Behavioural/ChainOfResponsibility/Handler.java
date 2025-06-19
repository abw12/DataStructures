package DesignPatterns.Behavioural.ChainOfResponsibility;

//handler interface or abstract class
public interface Handler {

    void setNextHandler(Handler supportHandler); //sets the next Handler in the chain
    void processRequest(Request request); // this API allows concrete handler to process the request
}
