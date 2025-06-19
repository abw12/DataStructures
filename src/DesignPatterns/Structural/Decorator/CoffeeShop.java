package DesignPatterns.Structural.Decorator;

public class CoffeeShop {

    public static void main(String[] args) {
        // creating a concrete class object
        HouseBlend houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription() + " : " + houseBlend.cost());

        // adding a decorator to the concrete class
        Milk milkAddOn = new Milk(houseBlend);
        System.out.println(milkAddOn.getDescription() + " : " + milkAddOn.cost());

        // passing a Decorator to another decoration ( this is known as recursive composition in OOP)
        Sugar sugarAddOn = new Sugar(milkAddOn);
        System.out.println(sugarAddOn.getDescription() + " : " + sugarAddOn.cost());
    }
}
