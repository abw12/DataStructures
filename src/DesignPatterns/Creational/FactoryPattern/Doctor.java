package DesignPatterns.Creational.FactoryPattern;

public class Doctor implements Profession{
    @Override
    public void print() {
        System.out.println("I'm a top Doctor");
    }
}
