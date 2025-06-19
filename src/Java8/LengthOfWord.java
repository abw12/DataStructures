package Java8;

import java.util.*;
import java.util.stream.Collectors;


public class LengthOfWord {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("abhi", "wasave","engineer","dream","discipline"));

        list.stream().map(word -> word.length() ).filter(word-> word > 5).forEach(System.out::println);
        //return the duplicate numbers from the list
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2,3,4,4,5,6,7,7,8,1,2));
        Set<Integer> uniqueNum=new HashSet<>();
        List<Integer> duplicateNumList = numbers.stream().filter(num -> !uniqueNum.add(num)).collect(Collectors.toList());
        System.out.println(duplicateNumList);

        //
    }
}
