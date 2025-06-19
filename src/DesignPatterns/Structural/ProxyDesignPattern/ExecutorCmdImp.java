package DesignPatterns.Structural.ProxyDesignPattern;

//This class represents the real object  ( also  known as real subject)

//This class implements the interface and contains the actual logic or operation that the client wants to use.
public class ExecutorCmdImp implements  Executors{

    @Override
    public void executeCommand(String query) throws Exception {
        System.out.println("Executing the Command:  "+ query);
    }
}
