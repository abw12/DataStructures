package Java8;

import java.util.*;
import java.util.stream.Collectors;

//import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class sortMap {

    public static void main(String[] args) {

        //Map.TreeMap<> implementation of the map interface will by default give an sorted natural ordering
        Map<String,Integer> map = new HashMap<>();
        map.put("abhishek",2);
        map.put("wasave",3);
        map.put("suresh",1);

        //traditional approach to sort a hashmap
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (int) o1.getValue() - o2.getValue() ;
            }
        });
//        System.out.println("Traditonal value: " + entries);


        //Use method reference in place of lambda expression wherever you can
        //using the LinkedHashMap to maintain the sort order after collecting the elements in new map
       Map<String,Integer> sortedByValue=map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(),(e1, e2) -> e2 ,LinkedHashMap::new));

        Map<String,Integer> sortedByValue2=map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(toMap(e -> e.getKey(), e -> e.getValue(),(e1, e2) -> e2 ,LinkedHashMap::new));
        System.out.println("Sorted By Value: "+sortedByValue);


        //sorting by key now and also using static imports of Collectors and map.Entry so that we can write a clean code
//        Use static import to shorten the code, when you use the static import feature
//        to import both Map.Entry and java.util.stream.Collectors classes
//        you can refer their methods without including class name like instead of Collectors.toMap() you can just use toMap().
        //also below making the use of method references like Map.Entry::getKey
        //we are using LinkedHashMap here as the return  type  to maintain the sorted order of the map
        Map<String,Integer> sortedByKey=map.entrySet().stream()
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)-> e2,LinkedHashMap::new));
//        System.out.println("Sorted By Key: "+sortedByKey);

        //sorting and then filtering by a letter
        map.entrySet().stream().sorted(comparingByValue())
                .filter(obj -> obj.getKey().startsWith("a"))
                .forEach(System.out::println);

        //first filtering the data and then sorting it
        map.entrySet().stream().filter(obj -> obj.getKey().startsWith("a"))
                .sorted(Map.Entry.comparingByKey()).forEach(System.out::println);


        //imported the static import of class Collections.reverseOrder()
        Map<String,Integer> reversedSortedByKey=map.entrySet().stream()
                .sorted(Collections.reverseOrder(comparingByKey()))
                .collect(toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)-> e2,LinkedHashMap::new));
//        System.out.println("Reverse Sorted By Key: " +reversedSortedByKey);

        List<Integer> sortedValues = map.values().stream().sorted(Comparator.reverseOrder()).limit(2).collect(Collectors.toList());
        System.out.println("SortedValues :" +sortedValues);

        ///////////////////////////////////////////////////////////////////////////


        Map<Integer,String> mapD = Map.of(1,"Abhi",6,"shek",3,"sur" ,7,"esh",5,"was",2,"ave",4,"engineer");

        Map<Integer, String> filteredSortedMap = mapD.entrySet().stream()
                .filter(entry -> entry.getKey() % 2 == 0)
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k1, k2) -> k2, LinkedHashMap::new));

        ////////the forEach method  of Map introduce in java 8 /////
        //it is just the functional styled way to iterate over all elements in the map
        filteredSortedMap.forEach((key,value) -> System.out.println(key + value));

        ///it's similar to the traditional approach ////
        for(Map.Entry<Integer,String> entry : filteredSortedMap.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }

        ///////////////////////////////////////////////////////////////////////////
        // keeping natural order of key using the treemap
        TreeMap<Integer, String> sortedMap = mapD.entrySet().stream()
                .filter(e -> e.getKey() % 2 == 0)
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2, TreeMap::new));

        System.out.println("Treemap :: " + sortedMap);


    }
}
