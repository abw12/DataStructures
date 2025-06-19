package ArraysPractise.LeetCode_Array;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerToRoman {

    public static void main(String[] args) {

        System.out.println(intToRoman(3540));
    }

    private static String intToRoman(int num){
        StringBuilder result= new StringBuilder();
        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(1, "I");
        numMap.put(4, "IV");
        numMap.put(5, "V");
        numMap.put(9, "IX");
        numMap.put(10, "X");
        numMap.put(40, "XL");
        numMap.put(50, "L");
        numMap.put(90, "XC");
        numMap.put(100, "C");
        numMap.put(400, "CD");
        numMap.put(500, "D");
        numMap.put(900, "CM");
        numMap.put(1000, "M");

        Map<Integer,String> sortedByKeys =  numMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->v2, LinkedHashMap::new));
        System.out.println(sortedByKeys);

        for(Map.Entry<Integer,String> entry : sortedByKeys.entrySet()){
            while(entry.getKey() <= num){
                result.append(entry.getValue());
                num-= entry.getKey();
            }
        }
        return result.toString();
    }
}
