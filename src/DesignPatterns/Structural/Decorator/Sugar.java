package DesignPatterns.Structural.Decorator;
//this is the concrete decorator class
public class Sugar extends AddOn{

    public Sugar(Beverage bev){
        super("Sugar",bev);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Sugar";
    }

    @Override
    public double cost() {
        return beverage.cost() + 50;
    }
}
