package DesignPatterns.Behavioural.State;

public class Client {

    public static void main(String[] args) {

        VendingMachineContext vendingMachineContext = new VendingMachineContext();

        //Set initial state to ReadyState
        vendingMachineContext.setCurrentState(new ReadyState());
        vendingMachineContext.request();

        // Change state
        vendingMachineContext.setCurrentState(new ProductSelectedState());

        // Request state change
        vendingMachineContext.request();

        // Change state
        vendingMachineContext.setCurrentState(new PaymentPendingState());

        // Request state change
        vendingMachineContext.request();

        // Change state
        vendingMachineContext.setCurrentState(new OutOfStockState());

        // Request state change
        vendingMachineContext.request();
    }
}
