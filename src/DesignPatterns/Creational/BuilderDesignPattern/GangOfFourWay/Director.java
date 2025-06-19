package DesignPatterns.Creational.BuilderDesignPattern.GangOfFourWay;

public class Director {
    private Builder builder;

    public Director(Builder builderType) {
        this.builder = builderType;
    }

    public Home getComplexObjectOfHome(){
        return  this.builder.getComplexHomeObject();
    }

    public void manageRequiredHomeConstruction(){
        this.builder.BuildFloor();
        this.builder.BuildPillars();
        this.builder.BuildWalls();
    }
}
