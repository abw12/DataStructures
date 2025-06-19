package DesignPatterns.Structural.Decorator;

//concrete component/class
public class DarkRoast extends Beverage{

    public DarkRoast(){
        super("Dark Roast Coffee");
    }
    @Override
    public double cost() {
        return 300;
    }
}
