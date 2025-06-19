package Map.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

    public static void main(String[] args) {

        Map<Integer,String> lhm = new LinkedHashMap<>(8,0.60f);
        lhm.put(1,"Abhishek");
        lhm.put(5,"Abhi");
        lhm.put(2,"Abhijit");
        lhm.put(4,"Abhilasha");
        lhm.put(3,"Aayushman");

        lhm.forEach((k,v) -> System.out.println("Key : "+ k + " value : " + v));

        //LinkedHashMap maintains the order of the keys
        Map<String,String> exMap = new HashMap<>(10,0.75f);
    }
}
