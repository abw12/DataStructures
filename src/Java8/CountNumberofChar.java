package Java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//WAP to count appearance of number of characters in a given string using java 8 stream api
public class CountNumberofChar {

    public static void main(String[] args) {
        String input="abhishek wasave";


        //groupingBy accept a classifier function and downstream collector
        Map<String, Long> characterCount = Arrays.stream(input.split("")).collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );
    //without the space character
        //chars() method will return an IntStream(codepoint value of character)
        Map<Character, Long> charCount = input.chars().mapToObj(ch -> Character.toLowerCase((char) ch))
                .filter(ch -> !Character.isWhitespace(ch)) //to ignore the whitespace in the sentence
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


        System.out.println(characterCount);
        System.out.println(charCount);
    }
}
