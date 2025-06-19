package Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparators {

    public static void main(String[] args) {

        //the below syntax is of Anonymous class in java which allow us to create an object of interface
        // this can be replaced by lambda expression
        Comparator<String> anonymousClass = new Comparator<String>(){
            //when you compare 2nd parameter with 1st than it sort in descending order
            public int compare(String i,String j){
                if(j.length() == i.length()){
                    return 0;
                } else if (j.length() > i.length()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        List<String> str = new ArrayList<>();
        str.add("Abhishek");
        str.add("Wasave");
        str.add("Abhijit");
        str.add("Bhumika");
        str.add("Nilema");

        //Collection.sort and ( Arrays.sort() when provided with customer comparator )  uses stable sorting algorithms
        // The sorting is stable, so same keys maintain their original order.
        Collections.sort(str,anonymousClass);
        str.forEach(v -> System.out.println(v));
    }
}
