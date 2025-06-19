package DesignPatterns.Structural.Facade;

public class NonvegRestaurant implements Hotel{

    @Override
    public Menus getMenus() {
        return new NonVegMenu();
    }
}
