package DesignPatterns.Behavioural.ChainOfResponsibility;
//Concrete handler class
public class Level2Support implements Handler{
    private Handler nextHandler; //ref to the next handler available in the chain
    @Override
    public void setNextHandler(Handler supportHandler) {
        this.nextHandler=supportHandler;
    }
    @Override
    public void processRequest(Request request) {
        if(request.getPriority() == Priority.INTERMEDIATE){
            System.out.println("Request is processed by level 2 support");
        }else if (nextHandler != null){
            nextHandler.processRequest(request); //forward the request to next handler in the chain
        }
    }
}
