package DesignPatterns.Creational.AbstractFactoryPattern;

public class AbstractFactoryProducer {

    public AbstarctFactory getProfessional(boolean isTrainee){
        if(isTrainee){
            return new TraineeFactory();
        } else{
            return new ProfessionalFactory();
        }

    }
}
