package OOP;

import java.util.ArrayList;
import java.util.List;

abstract class Car{
    private String companyName;
    private boolean Ev;
    //getter method which give the encapsulation and abstraction property here
    public boolean IsEv(){
        return this.Ev;
    }
    public void setIsEv(boolean value){
        this.Ev=value;
    }

    public String getCompanyName(){
        return this.companyName;
    }
    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }

    abstract String engine();
    abstract int noOfGears();
    abstract String colour();
    abstract String manufacturer();

    //non-abstract method which is common for all
    public void wheels(){
        System.out.println("Four Wheel Drive");
    }
}

class BMW extends Car{
    //non-abstract getter methid


    @Override
    String engine() {
        return "v*8 Turbo Engine";
    }

    @Override
    int noOfGears() {
        return 6;
    }

    @Override
    String colour() {
        return "Cyan";
    }

    @Override
    String manufacturer() {
        return "germany";
    }
}

class Mercedes extends Car{


    @Override
    String engine() {
        return "v12 turbo american engine";
    }

    @Override
    int noOfGears() {
        return 8;
    }

    @Override
    String colour() {
        return "Matt black";
    }

    @Override
    String manufacturer() {
        return "America";
    }
}

public class AbstractionExample {

    public static void main(String[] args) {

        Car bmw = new BMW();
        bmw.setIsEv(false);
        bmw.setCompanyName("BMW");
        System.out.println(bmw.engine());

        Car mercedes = new Mercedes();
        mercedes.setIsEv(true);
        mercedes.setCompanyName("mercedes");
        System.out.println(mercedes.engine());
        List<String> evCars =new ArrayList<>();


        if(bmw.IsEv()){
            evCars.add(bmw.getCompanyName());
        }else if(mercedes.IsEv()){
            evCars.add(mercedes.getCompanyName());
        }
        bmw.wheels();
        mercedes.wheels();
        System.out.println(evCars);
    }
}
