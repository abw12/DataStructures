package Comparators;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class laptop {
    private double price;
    private String name;
    private int ram;

    public laptop(double price, String name, int ram) {
        this.price = price;
        this.name = name;
        this.ram = ram;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "laptop{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", ram=" + ram +
                '}';
    }
    //we will have to implement the comparable interface on this class to use below method
//    @Override
//    public int compareTo(laptop lap2) {
//        if(this.price < lap2.price)
//            return -1;
//        else
//            return 1;
//    }
}


public class ComparatorvsComparable {

    public static void main(String[] args) {
        List<laptop> list = Stream.of(new laptop(80000,"Victus",16),
                new laptop(180000,"AlienWare",20),
                new laptop(120000,"Apple",4),
                new laptop(70000,"MSI",8)
                ).collect(Collectors.toList());

        //using comparator we don't have to implement the comparable interface in laptop class
        Collections.sort(list, new Comparator<laptop>() { //anonymous new comparator can be replaced with lambda expression
            @Override
            public int compare(laptop o1, laptop o2) {
                if(o1.getPrice() < o2.getPrice())
                    return -1;
                else
                    return 1;
            }
        });
//
//        ///above code modified to implement lambda expression
//        Collections.sort(list,(o1,o2) -> {
//            if(o1.getPrice() < o2.getPrice()){
//                return -1;
//            }else{
//                return 1;
//            }
//        });
        for(laptop laptop:list ){
            System.out.println(laptop);
        }



    }

}
