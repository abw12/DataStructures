package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelsUsingStreams {

    public static void main(String[] args) {
        long vowelsCount=0; long consonentCount=0; //consonent are remaining alphabets after removing the 5 vowels from 26 alphabets in eng
        List<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u'));

        String input="Abhishek";
        input=input.toLowerCase();

        vowelsCount=input.chars().filter(currentChar -> vowels.contains((char)currentChar)).count();

        consonentCount=input.chars().filter(currentChar -> !vowels.contains((char)currentChar))
                .filter(nonVowelCh -> (nonVowelCh >='a' && nonVowelCh<='z')).count();

        System.out.println("Vowels in given string : "+ vowelsCount);
        System.out.println("Consonent in given string: "+ consonentCount);
    }
}
