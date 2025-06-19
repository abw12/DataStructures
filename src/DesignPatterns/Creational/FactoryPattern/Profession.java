package DesignPatterns.Creational.FactoryPattern;

public interface Profession {

    void print();

    default String test(){
        return "hello";
    }
}
