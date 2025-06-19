package DesignPatterns.Structural.Facade;


//this is the facade class whose method will be used by the client code to access the subsystem via facade class

//From this, It is clear that the complex implementation will be done by HotelKeeper himself.
// The client will just access the HotelKeeper and ask for either Veg, NonVeg or VegNon Both Restaurant menu.
public class HotelKeeperImplementation implements HotelKeeper{
    @Override
    public VegMenu getVegMenu() {
        VegRestaurant v = new VegRestaurant();
        VegMenu vegMenu = (VegMenu)v.getMenus();
        return vegMenu;
    }

    @Override
    public NonVegMenu getNonVegMenu() {
       NonvegRestaurant nv =new NonvegRestaurant();
        NonVegMenu nvm = (NonVegMenu)nv.getMenus();
        return nvm;
    }

    @Override
    public Both getVegNonMenu() {
        VegnonBothRestaurant bothRestaurant = new VegnonBothRestaurant();
        Both bothMenu = (Both)bothRestaurant.getMenus();
        return bothMenu;
    }
}
