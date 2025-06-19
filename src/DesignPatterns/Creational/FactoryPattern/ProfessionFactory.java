package DesignPatterns.Creational.FactoryPattern;

public class ProfessionFactory {

        public Profession getProfession(String object){
        if(object == null){
            return null;
        }
        if(object.equals("Doctor")){
            return new Doctor();
        }
        if(object.equals("Army")){
            return  new Army();
        }
        if(object.equals("Engineer")){
            return  new Engineer();
        }
        return null;
    }
}
