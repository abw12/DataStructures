package DesignPatterns.Structural.Facade;

public class VegRestaurant implements Hotel{
    @Override
    public Menus getMenus() {
        return new VegMenu();
    }
}
