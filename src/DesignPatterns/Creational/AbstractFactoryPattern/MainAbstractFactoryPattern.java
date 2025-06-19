package DesignPatterns.Creational.AbstractFactoryPattern;

public class MainAbstractFactoryPattern {
    public static void main(String[] args) {

        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
        AbstarctFactory abstarctFactory = abstractFactoryProducer.getProfessional(false);
        Profession profession=abstarctFactory.getProfession("Engineer");
        profession.print();
    }
}
