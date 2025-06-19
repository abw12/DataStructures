package DesignPatterns.Creational.AbstractFactoryPattern;

public class Engineer implements Profession{
    @Override
    public void print() {
        System.out.println("I'm a Pro Engineer");
    }
}
