package DesignPatterns.Behavioural.State;

public class VendingMachineContext {

    private VendingMachineState currentState;
    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public void request(){
        currentState.handleRequest();
    }

}
