package DesignPatterns.ImmutableClasses;

import DesignPatterns.Creational.SingletonPattern.SingletonClass;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String,String> emails = new HashMap<>();

        emails.put("Primary","wasaveabhishek@gmail.com");

        SingletonClass singleton1 = SingletonClass.getInstance();
        singleton1.init("vedant",101);
        System.out.println(singleton1);
        singleton1.init("Abhishek",100);
        System.out.println(singleton1);

        //this will also print abhishek as all the instances of the SIngleton clas point to the same reference
        SingletonClass singleton2 = SingletonClass.getInstance();
        System.out.println(singleton2);

        ImmutableClass imc1 = ImmutableClass.getImmutableInstance("abhishek",12234,new Date(),emails);

        ImmutableClass imc2 = ImmutableClass.getImmutableInstance("vedant",1112,new Date(),emails);

        System.out.println("original: " + imc1);
        tryModification(imc1.getImmutableField1(),imc1.getImmutabaleField2(),imc1.getMuttableField(),emails);
        System.out.println("Modified: " +imc1);
        System.out.println("second obj: " +imc2);

    }

    //As it can be seen that even changing the instance variables using their references does not change
    // their value, so the class is immutable.
    private static void tryModification(String field1,Integer field2 ,Date date,Map<String,String> emails){
        field1="vedant";
        field2=33333;
        date.setDate(10);
        emails.put("Primary","abhishekwasave12@gmail.com");
    }


}
