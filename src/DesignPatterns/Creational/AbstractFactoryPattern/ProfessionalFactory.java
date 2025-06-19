package DesignPatterns.Creational.AbstractFactoryPattern;

public class ProfessionalFactory extends AbstarctFactory{


    @Override
    Profession getProfession(String typeOfProfession) {
        if(typeOfProfession == null){
            return null;
        }
        if(typeOfProfession.equals("Engineer")){
            return  new Engineer();
        }
        if(typeOfProfession.equals("Teacher")){
            return new Teacher();
        }
        return null;
    }
}
