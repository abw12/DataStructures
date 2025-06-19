package DesignPatterns.Creational.BuilderDesignPattern.GangOfFourWay;

public class MainBuilderPattern {

    public static void main(String[] args) {

        EarthQuackResistenBuilder earthQuackResistenBuilder = new EarthQuackResistenBuilder();
        FloodeResistentBuilder floodeResistentBuilder =new FloodeResistentBuilder();

        Director director =new Director(earthQuackResistenBuilder);
        Director directo2 =new Director(floodeResistentBuilder);
        director.manageRequiredHomeConstruction();
        directo2.manageRequiredHomeConstruction();
        Home homeConstructionAtTheEnd = director.getComplexObjectOfHome();
        Home homeConstructionAtTheEnd1 = directo2.getComplexObjectOfHome();
        System.out.println(homeConstructionAtTheEnd.floors);
        System.out.println(homeConstructionAtTheEnd.walls);
        System.out.println(homeConstructionAtTheEnd.pillars);
        System.out.println(homeConstructionAtTheEnd);

        System.out.println(homeConstructionAtTheEnd1.floors);
        System.out.println(homeConstructionAtTheEnd1.walls);
        System.out.println(homeConstructionAtTheEnd1.pillars);
        System.out.println(homeConstructionAtTheEnd1);

    }
}
