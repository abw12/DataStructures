package DesignPatterns.Structural.ProxyDesignPattern;

//real object interface/abstract class( also known as subject interface)
//Define an interface or abstract class that represents the operations the real object will provide. Both the real object and proxy will implement this interface.
public interface Executors {

    void executeCommand(String query) throws Exception;
}
