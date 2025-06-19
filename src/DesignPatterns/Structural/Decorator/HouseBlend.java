package DesignPatterns.Structural.Decorator;

//concrete component/class
public class HouseBlend extends Beverage{

    public HouseBlend(){
        super("House Blend Coffee");
    }
    @Override
    public double cost() {
        return 250;
    }
}
