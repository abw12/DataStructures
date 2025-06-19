package DesignPatterns.Behavioural.ChainOfResponsibility;
//Concrete handler class
public class Level1Support implements Handler{
    private Handler nextHandler;
    @Override
    public void setNextHandler(Handler supportHandler) {
        this.nextHandler=supportHandler;
    }

    @Override
    public void processRequest(Request request) {
        if(request.getPriority() == Priority.BASIC){
            System.out.println("Request is processed by level 1 support");
        }else if (nextHandler != null){
            nextHandler.processRequest(request); //forward the request to next handler in the chain
        }
    }
}
