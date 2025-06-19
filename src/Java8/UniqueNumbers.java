package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueNumbers {

    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,3,4,5,6,6));

        List<Integer> list1= list.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(list1);

        //sorted ascending order
//        list.stream().sorted().forEach(System.out::print);
        //sorted descending order
        List<Integer> descSorted = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted Descending: "+descSorted);

        int[]  x = {120, 200, 016}; //016 is octal number its decimal equivalent is 14.

//        for(int i = 0; i < x.length; i++){
//            System.out.print(x[i] + " ");
//        }


    }
}
