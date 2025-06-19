package DesignPatterns.Structural.Decorator;

//this is the concrete decorator class
public class Milk extends AddOn{

    public Milk(Beverage bev){
        super("Milk",bev);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 100;
    }
}
