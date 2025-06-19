package DesignPatterns.Creational.FactoryPattern;

public class MianFactoryPattern {
    public static void main(String[] args) {
        ProfessionFactory pf =new ProfessionFactory();
        Profession pro = pf.getProfession("Army");
        if(pro !=null) {
            pro.print();
            String Hello = pro.test();
            System.out.println(Hello);
        }
    }
}
