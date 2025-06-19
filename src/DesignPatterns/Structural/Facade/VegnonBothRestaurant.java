package DesignPatterns.Structural.Facade;

public class VegnonBothRestaurant implements Hotel{

    @Override
    public Menus getMenus() {
        return new Both();
    }
}
