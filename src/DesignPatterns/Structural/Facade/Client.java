package DesignPatterns.Structural.Facade;

public class Client {

    public static void main(String[] args) {
        HotelKeeper keeper = new HotelKeeperImplementation(); //this way client code is kept lean and using only the instance of HotelKeeper we can access the subsystem classes/interfaces (this comes handy in complex code structure )

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both bothMenu = keeper.getVegNonMenu();
    }
}
