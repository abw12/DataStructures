package DesignPatterns.Behavioural.ChainOfResponsibility;
//Concrete handler class
public class Level3Support implements Handler{

    @Override
    public void setNextHandler(Handler supportHandler) {
        // Level3support does not have anything next in chain ( no next handler present)
    }
    @Override
    public void processRequest(Request request) {
        if(request.getPriority() == Priority.CRITICAL){
            System.out.println("Request is processed by level 3 support");
        }else{
            System.out.println("Request cannot be handled");
        }
    }
}
