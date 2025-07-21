package Java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {

    public static String alphabetize(String word) {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args){
        File dictionary = new File("C:\\Users\\wasav\\IdeaProjects\\DataStructures\\src\\Java8\\AnagramInput");
        int minGroupSize=2;

        GroupAnagramsIterativeWay obj1 = new GroupAnagramsIterativeWay();
        GroupAnagramsUsingJava8 obj2 = new GroupAnagramsUsingJava8();
        GroupAnagramsLeetCode obj3 = new GroupAnagramsLeetCode();
//        try {
//            obj1.anagramsUsingIteration(dictionary,minGroupSize);
//            System.out.println("============================================");
//            obj2.anagramsUsingStream(minGroupSize);
            obj3.groupAnagrams();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}

class GroupAnagramsIterativeWay {

    public void anagramsUsingIteration(File file,int minSize ) throws IOException {

        Map<String, Set<String>> groups = new HashMap<>();
        try(Scanner s = new Scanner(file)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(Anagrams.alphabetize(word), (unsused) -> new TreeSet<>()).add(word);
            }
        }
            for(Set<String> group :groups.values()){
                if(group.size() >= minSize){
                    System.out.println(group.size()+" : " + group);
                }
            }
    }
}

class GroupAnagramsUsingJava8 {

    public void anagramsUsingStream(int minSize) throws IOException {
//        Path dictionary = Paths.get("C:\\Users\\wasav\\IdeaProjects\\DataStructures\\src\\Java8\\AnagramInput");
        try(Stream<String> words = Files.lines(Paths.get("C:\\Users\\wasav\\IdeaProjects\\DataStructures\\src\\Java8\\AnagramInput"))){
            words.collect(groupingBy(
                    word -> Anagrams.alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minSize)
                    .forEach(group -> System.out.println(group.size() +" : "+group));
        }
    }
}



class GroupAnagramsLeetCode{


    public void groupAnagrams(){
        String[] input = {"eat","ate","tan","tea","nat","bat","tab"};
        System.out.println(createGroup(input));

    }

    public List<List<String>> createGroup(String[] input){
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str : input){
            String hashCode = encode(str);
            if(map.containsKey(hashCode)){
                map.get(hashCode).add(str);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(hashCode,newList);
            }
        }
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    private String encode(String str){

        int[] alpha = new int[26];

        for(int i=0; i < str.length() ;i++){
            alpha[str.charAt(i) - 'a']++ ;//counting the alphabet at the given index
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < alpha.length ; i++){
            sb.append(alpha[i]).append("-");
        }
        return sb.toString();
    }



}
