package DesignPatterns.Behavioural.ChainOfResponsibility;

public class Request {
    private Priority priority;

    public Request(Priority priority){
        this.priority=priority;
    }


    public Priority getPriority() {
        return priority;
    }

}
