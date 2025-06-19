package BasicPrograms;

import java.io.IOException;


class Parent {
    void m1(){
        System.out.println("Parent m1");
    }
    void m2() throws ArithmeticException, IOException {
        System.out.println("Parent m2");
    }
    void m3() throws ArithmeticException{
        System.out.println("Parent m3");
    }
    void m4() throws NullPointerException, Exception {
        System.out.println("Parent m4");
    }
    void m5(){
        System.out.println("Parent m5");
    }
}
class Child extends Parent{
    void m1(){
        System.out.println("Child m1");
    }
    void m2() throws IOException {
        System.out.println("Child m2");
    }
    void m3() throws RuntimeException {
        System.out.println("Child m3");
    }
    void m4() throws Exception{
        System.out.println("Child m4");
    }
    void m6(){
        System.out.println("Child m6");
    }
}


public class HereTechQuestion {
    public static void main(String[] args) {
        Child c =new Child();

        //below statement is similar of doing the Parent p = new Child();
        Parent p = c;
        p.m1(); // print child m1
//        p.m2(); // will throw an compile time exception  to handle IOException using try-catch block or add throws keyword on main method signature
        p.m3(); // will not give a compile time exception bcoz its an runtimeexception being thrown , still need to handle it properly in case of any exception occured
//        p.m4(); // will throw an compile time exception  to handle Exception using try-catch block or add throws keyword on method
        p.m5(); // print parent m5
//        p.m6(); //child m6 //this will give an  error since m6() is not present in the parent class and we are using parent ref


        /////1st round

        String str = "TaBlE";
        StringBuilder result = new StringBuilder();
        for(Character ch : str.toCharArray()){
            if(Character.isLowerCase(ch)){
                result.append(Character.toUpperCase(ch));
            }else if(Character.isUpperCase(ch)){
                result.append(Character.toLowerCase(ch));
            }
        }
        System.out.println(result);
    }
}