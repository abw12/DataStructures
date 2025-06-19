package DesignPatterns.Behavioural.IteratorDesignPattern.example2;

// iterator interface ( this example is using the custom iterator class which we are creating and not using the java defined iterator
public interface Iterator<T> {

    boolean hasNext();
    T next();
}
