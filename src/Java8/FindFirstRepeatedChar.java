package Java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedChar {

    public static void main(String[] args) {
        String sent="America is my dream country";
        //find first repeating character in the given String
        Character result = sent.chars()
                .mapToObj(ch -> Character.toLowerCase((char) ch)) //First convert to character obj then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //store the char in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(result);

    }
}
