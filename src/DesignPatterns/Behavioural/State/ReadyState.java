package DesignPatterns.Behavioural.State;

//Concrete State Class
public class ReadyState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Ready state: Please select a product.");
    }
}
