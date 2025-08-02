package LeetCode.LinkedList;

import java.util.*;
import java.util.LinkedList;

public class TestLinkedListExample {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for(int i =1 ; i <= 100 ; i++){
            list.add(i);
            set.add(i);
        }

        System.out.println("List: " + list.toString());
        System.out.println("Set: " + set.toString());



    }
}
