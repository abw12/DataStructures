package DesignPatterns.Structural.Adaptor;

// Interface Adapter

public abstract class InterfaceAdaptor implements AnotherPlayer {

    @Override
    public void playMp3(String fileName) {
        // Default implementation
    }

    @Override
    public void playVlc(String fileName) {
        // Default implementation
    }

    @Override
    public void playMp4(String fileName) {
        // Default implementation
    }
}
