package DesignPatterns.Creational.PrototypeDesignPattern;

import DesignPatterns.Creational.PrototypeDesignPattern.Example1.Profession;
import DesignPatterns.Creational.PrototypeDesignPattern.Example1.ProfessionCache;

public class MainPrototypeDesignPattern {

    public static void main(String[] args) {
        ProfessionCache.loadProfessionCache();

        Profession doctor1=ProfessionCache.getProfessionClone(1);
//        doctor1.print();
        System.out.println(doctor1);

        Profession teacher=ProfessionCache.getProfessionClone(2);
//        teacher.print();
        System.out.println(teacher);


        Profession engineer=ProfessionCache.getProfessionClone(3);
//        engineer.print();
        System.out.println(engineer);

        //this will create a clone from the exiting doctor obj which we get from the cache map rather than creating new instances
        Profession doctor2=ProfessionCache.getProfessionClone(1);
//        doctor2.print();
        System.out.println(doctor2);



    }
}
