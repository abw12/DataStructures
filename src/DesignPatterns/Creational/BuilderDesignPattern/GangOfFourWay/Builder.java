package DesignPatterns.Creational.BuilderDesignPattern.GangOfFourWay;

interface Builder {

    void BuildFloor();
    void BuildWalls();
    void BuildPillars();

    Home getComplexHomeObject();
}
