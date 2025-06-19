package DesignPatterns.Creational.AbstractFactoryPattern;

public class Teacher implements Profession{
    @Override
    public void print() {
        System.out.println("I'm a Pro Teacher");
    }
}
