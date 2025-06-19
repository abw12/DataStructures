package DesignPatterns.Behavioural.IteratorDesignPattern.example2;

// Aggregate interface
public interface Aggregate<T> {

    Iterator<T> createIterator();
}
