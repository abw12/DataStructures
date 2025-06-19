package DesignPatterns.Creational.BuilderDesignPattern.GangOfFourWay;

public class FloodeResistentBuilder implements Builder{
    private Home  floodeResistentBuilder =new Home();


    @Override
    public void BuildFloor() {
        this.floodeResistentBuilder.walls="Waterproof walls";
    }

    @Override
    public void BuildWalls() {
        this.floodeResistentBuilder.pillars="Strong walls";
    }

    @Override
    public void BuildPillars() {
        this.floodeResistentBuilder.floors="strong floors";
    }

    @Override
    public Home getComplexHomeObject() {
        return this.floodeResistentBuilder;
    }
}
