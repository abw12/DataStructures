package Java8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMethodsJava8 {

    private static Map<String, Employee> map1 = new HashMap<>();
    private static Map<String, Employee> map2 = new HashMap<>();

    ////////the forEach method  of Map introduce in java 8 /////
    //it is just the functional styled way to iterate over all elements in the map
    public static void print(Map<String, Integer> map) {
        map.forEach((key, value) -> {
            System.out.println(key + "-" + value);
        });
        //prior to java 8
//        for(Map.Entry<String,Integer> entry : map.entrySet()){
//            System.out.println(entry.getKey() + "-"+ entry.getValue());
//        }
    }

    public static void mergeFunctionDemo(Map<String, Integer> productsQuantity) {
        //merge():

        //The merge() function works as follows;
        // if the specified key isn't already associated with a value, or the value is null, it associates the key with the given value.
        //Otherwise, it replaces the value with the results of the given remapping function.
        // If the result of the remapping function is null, it removes the result.
        int result = productsQuantity.merge("Cream", 100, (v1, v2) -> v1 + v2); //v1 and v2 are the two values that need to be merged
        //so v1(newValue) will be the value that we passed on with key (ie 100 here) and v2(oldValue) will be the value that is currently associated with key "Cream"
        System.out.println(result);

        //if the existing value associated with key is not present or its null than ignore the remapping function just associate the passed value with the key
        productsQuantity.put("ice", null);
        productsQuantity.merge("ice", 88, (v1, v2) -> v1 + v2); // it directly perform put operation
//        print(productsQuantity);

        //the value you pass in cannot be null .. bcoz this is the value you want to merge so will throw an error
//        productsQuantity.merge("ice",null,(v1,v2) -> v1 + v2);
//        print(productsQuantity);

        //hashmap support the null keys so for hashmap we can pass in the key key
        productsQuantity.merge(null, 0, (v1, v2) -> v1 + v2);
//        print(productsQuantity);

        //removes the entry if the BiFunction evaluates to null
        //so be careful while writing the remapping function
        productsQuantity.merge("ice", 60, (v1, v2) -> null); //this will remove the entire entry for key ice
//        print(productsQuantity);

        Employee employee1 = new Employee(1L, "Henry");
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee(2L, "George");
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee(3L, "Henry");
        map2.put(employee5.getName(), employee5);
        //Note that we have identical keys for the employee1 and employee5 entries in our maps, which we'll use later.

        Map<String, Employee> map3 = new HashMap<>(map1);

//        map3.values().stream().sorted().collect(Collectors.toList());

        //merging the entries from map2 into map3
        map2.forEach((key, value) ->
                map3.merge(key, value, (v1, v2) -> new Employee(v1.getId(), v2.getName())));

        map3.forEach((k, v) -> System.out.println(k + " - " + v));
        //notice the result will merge the map2 entries in map3 and also the duplicate(henry)
        // will only appear once in the resultant map
    }

    public static void main(String[] args) {
        Map<String, Integer> productsQuantity = new HashMap<>();
        productsQuantity.put("Cheese", 5);
        productsQuantity.put("Butter", 60);
        productsQuantity.put("Ghee", 36);

        //////getOrDefault /////
        ///Using the getOrDefault() method, we can get a value from the map or return a default element
        // in case there is no mapping for the given key:
        productsQuantity.put("Milk", productsQuantity.getOrDefault("Milk", 55));

        //prior to java 8
        Integer milkCount = productsQuantity.containsKey("milk") ? productsQuantity.get("Milk") : 55;


        ///PutIfAbsent
//        With this method, we can add a new mapping, but only if there is not yet a mapping for the given key:
        productsQuantity.putIfAbsent("Cream", 70);

        //prior to java 8
        if (productsQuantity.containsKey("cream")) {
            productsQuantity.put("cream", 80);
        }

        //mergeMethod example
        mergeFunctionDemo(productsQuantity);

        //example of merge function in the Collection.toMap() method
        Map<String,Integer> map1 = Map.of("abhi",25,"vedant",28);
        Map<String,Integer> map2 = Map.of("abhi",27,"sarang",26);

        Map<String, Integer> mergedMap = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> newValue  //merge function(bi-function)
                ));
        System.out.println(mergedMap);
    }

    static class Employee {
        private Long id;
        private String name;

        public Employee(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
