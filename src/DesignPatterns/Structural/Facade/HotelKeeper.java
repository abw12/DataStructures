package DesignPatterns.Structural.Facade;

//interface for the facade, client will use only these methods to get all the  types of menu options available
// it is known as the unified interface.
public interface HotelKeeper {

    public VegMenu getVegMenu();
    public NonVegMenu getNonVegMenu();
    public Both getVegNonMenu();
}
