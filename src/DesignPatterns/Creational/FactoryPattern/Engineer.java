package DesignPatterns.Creational.FactoryPattern;

//this is the concrete class since it implement all the methods of the Profession interface
public class Engineer implements Profession{

    @Override
    public void print() {
        System.out.println("I'm an Engineer at Google");
    }

    @Override
    public String test() {
        return "Hello I'm Engineer";
    }

}
