package DesignPatterns.Creational.BuilderDesignPattern.GangOfFourWay;

public class EarthQuackResistenBuilder implements Builder{

    private Home earthQuackResistenBuilder =new Home();

    @Override
    public void BuildFloor() {
        this.earthQuackResistenBuilder.floors="Wooden Floors";
    }

    @Override
    public void BuildWalls() {
        this.earthQuackResistenBuilder.walls="Wooden Walls";
    }

    @Override
    public void BuildPillars() {
        this.earthQuackResistenBuilder.pillars="Concrete pillars";
    }

    @Override
    public Home getComplexHomeObject() {
        return this.earthQuackResistenBuilder;
    }
}
