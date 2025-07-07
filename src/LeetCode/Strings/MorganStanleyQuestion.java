package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MorganStanleyQuestion {
    //given input string should be re-constructed in sorted order according to the
    // characters and if same number two character appeared than order it alphabatically
    public static void main(String[] args) {
        String s ="aabbccc";

        Map<Character,Integer> map =new HashMap<>();

        for(int i=0 ; i < s.length() ; i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        String output = map.entrySet().stream().sorted((entry1, entry2) -> {
                    int result = entry2.getValue().compareTo(entry1.getValue()); // Sort by count (descending)
                    if (result == 0) {
                        result = entry1.getKey().compareTo(entry2.getKey()); // Sort alphabetically
                    }
                    return result;
                })
                .map(entry -> entry.getKey().toString().repeat(entry.getValue()))
                .collect(Collectors.joining());
        System.out.println(output);
    }
}
