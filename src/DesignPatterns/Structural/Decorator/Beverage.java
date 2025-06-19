package DesignPatterns.Structural.Decorator;

//Component Interface/abstract class
public abstract class Beverage {

    private String description;

    public Beverage(String description){
        super();
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
