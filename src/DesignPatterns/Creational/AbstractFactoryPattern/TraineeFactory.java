package DesignPatterns.Creational.AbstractFactoryPattern;

public class TraineeFactory extends AbstarctFactory{

    @Override
    Profession getProfession(String typeOfProfession) {
        if(typeOfProfession == null){
            return null;
        }
        if(typeOfProfession.equals("Engineer")){
            return new TraineeEngineer();
        }
        if(typeOfProfession.equals("Teacher")){
            return new TraineeTeacher();
        }
        return null;
    }
}
