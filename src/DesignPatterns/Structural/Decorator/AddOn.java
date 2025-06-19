package DesignPatterns.Structural.Decorator;

// this is the Decorator
public abstract class AddOn extends Beverage{

    //Reference to Component object ( also known as Ref to wrapped component object)
    protected Beverage beverage;
    public AddOn(String description,Beverage bev) {
        super(description);
        this.beverage=bev;
    }

    public abstract String getDescription();
}
