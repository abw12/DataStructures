package DesignPatterns.Creational.SingletonPattern;

import DesignPatterns.Creational.AbstractFactoryPattern.Teacher;

public class MainSingleton {
    public static void main(String[] args) {
        SingletonClass singletonClass1= SingletonClass.getInstance();
        singletonClass1.init("abhishek",1);
        singletonClass1.print();

        SingletonClass singletonClass2=SingletonClass.getInstance();
        singletonClass2.init("Vedant",2);
        singletonClass2.print();


        Teacher teacher1 = new Teacher();
        teacher1.print();
        System.out.println("HashCode of Teacher1: " + teacher1);

        Teacher teacher2 = new Teacher();
        System.out.println("HashCode of Teacher2: " + teacher2);
    }
}
