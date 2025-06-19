package Java8;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseStringJava8 {

    public static void main(String[] args) {
        String name = "abhishek";

        String reverseString=Arrays.asList(name)
                .stream()
                .map(str -> new StringBuilder(str).reverse().toString())
                .collect(Collectors.toList()).get(0);
        System.out.println(reverseString);
    }
}
