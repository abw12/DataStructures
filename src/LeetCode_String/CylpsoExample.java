package LeetCode_String;

import java.util.HashMap;
import java.util.Map;

public class CylpsoExample {

    public static void main(String[] args) {
//		Write a program to determine the average of each key using the total value of the key
//		Example:
//		Avg of A = <value>
//		Avg of B = <value>
//		Avg of C = <value>
//		Avg of D= <value>

        String input="A-13,C-10,B-45,B-100,A-16,D-102,C-133,D-143,B-90,A-56,C-256";
        String[] arr=input.split(",");
        Map<String,Integer> map =new HashMap<>();
        Map<String,Integer> count = new HashMap<>();


        for(String elem : arr) {

            String[] data = elem.split("-");
            String alphabet = data[0].trim();
            Integer num = Integer.valueOf(data[1].trim());

            if(map.containsKey(alphabet)) {
                Integer n = map.get(alphabet);
                Integer sum= n + num;
                map.put(alphabet,sum); //adding & maintaining sum of integer in one map
                count.put(alphabet,count.get(alphabet) +1); //maintaining separate map for occurrence of the alphabet

            }else {
                map.put(alphabet, num);
                count.put(alphabet, 1);
            }

        }

        Integer avg_A = map.get("A") / count.get("A");
        Integer avg_B = map.get("B") / count.get("B");
        Integer avg_C = map.get("C") / count.get("C");
        Integer avg_D = map.get("D") / count.get("D");
        System.out.println("Average of A: "+avg_A);
        System.out.println("Average of B: "+avg_B);
        System.out.println("Average of C: "+avg_C);
        System.out.println("Average of D: "+avg_D);


        String s1= new String("cylpso");
        String s2= new String("cylpso");
        String s3=s1;
        String s4=s2;

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));


    }
}
