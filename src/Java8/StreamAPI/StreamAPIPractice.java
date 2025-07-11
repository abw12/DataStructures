package Java8.StreamAPI;


import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

class Student {
    private String name;
    private String subject;
    private Integer marks;

    public Student(String name, String subject, Integer marks) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                '}';
    }
}

//This class is used to practice different Stream API questions
public class StreamAPIPractice {

    public static void main(String[] args) {
        List<Student> listOfStudents = Stream.of(
                new Student("Abhishek","Science",80),
                new Student("Abhishek","Math",85),
                new Student("Abhishek","History",95),
                new Student("Sara","Science",90),
                new Student("Sara","Math",91),
                new Student("Sara","History",88)
                ).collect(Collectors.toList());


        List<EmplooyeeData> data = Stream.of(new EmplooyeeData("Abhishek","Dev",60000,3),
                new EmplooyeeData("Manali","Dev",80000,14),
                new EmplooyeeData("Jashma","QA",50000,4),
                new EmplooyeeData("Amit","QA",120000, 3),
                new EmplooyeeData("Manoj","Dev",160000,14),
                new EmplooyeeData("Mahesh","Dev",260000,20),
                new EmplooyeeData("Vishal","DevOps",160000,15),
                new EmplooyeeData("Inder","DevOps",100000,18)
        ).toList();

        //Find total marks per student
        Map<String, Integer> groupedByName = listOfStudents.stream()
                .collect(Collectors.groupingBy(
                        Student::getName,
                        Collectors.summingInt(Student::getMarks)
                        )
                );
        System.out.println(groupedByName);

        //Find each student subject with maximum marks

        // This solution  involves two separate stream operations
//        First, you group the students and find the one with the maximum marks, resulting in a Map<String, Optional<Student>>.
//        Then, you create a new stream from this map's entry set to transform it into the final Map<String, String>.
        Map<String, String> topMarks = listOfStudents.stream()
                .collect(Collectors.groupingBy(
                        Student::getName,
                        Collectors.maxBy(Comparator.comparingInt(Student::getMarks))
                        )
                    )
                .entrySet()
                .stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey, entry -> entry.getValue().orElseGet(null).getSubject())
                );
        // Optimal solution which find the answer in single pass of the stream using the collectingAndThen method
        /* 1. A collector: Collectors.maxBy(Comparator.comparingInt(Student::getMarks)) finds the student with the highest marks
        in each group, resulting in an Optional<Student>.
        2. A finishing function: optStudent -> optStudent.map(Student::getSubject).orElse("") is a function that takes the result of the
        maxBy collector (the Optional<Student>) and transforms it.It safely extracts the student's subject, providing an empty string if the
        optional were for some reason empty.*/
        Map<String,String> topMarks2 = listOfStudents.stream()
                        .collect(Collectors.groupingBy(
                                Student::getName,
                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student::getMarks)),
                                        opsStudents -> opsStudents.map(Student::getSubject).orElse("")
                                )
                        ));
        System.out.println(topMarks);
        System.out.println(topMarks2);

        ////////////////////////////////////////////////////////

        //Suppose:
        //We want to generate random IDs for new users.
        //We have a list of user names.
        //We want to combine each random ID with the user name to produce a final label like:
        // "UserID: <random-id> | Name: <uppercase-name>"
        List<String> userNameList = List.of("Abhishek","Sara","Samiksha","Vedant");

        // create a supplier to form the random uuid strings
        Supplier<String> supplierIds = () -> UUID.randomUUID().toString();

        // Function to convert the names to uppercase
        Function<String,String> functionUpperCase = name -> name.toUpperCase(); //can be changed to method reference

        //combine the random uuid and uppercase name using th BiFunction
        BiFunction<String,String,String> combineFunc = (id,username) -> "UserID: " + id + " | Name: " + username;

        List<String> userNameWithUUID = userNameList.stream()
                .map(functionUpperCase)
                .map(name -> {
                    String randomId = supplierIds.get(); //calling the supplier function which will return an random UUID
                    return combineFunc.apply(randomId, name);
                })
                .collect(Collectors.toList());
        System.out.println(userNameWithUUID);

        ////////////////////////////////////////////////////////

        // How sorting and ordering works in Treemap vs LinkedHashMap

        ///////////////////////////////////////////////////////////////////////////

        //Treemap output will sort the keys in alphabatical order maintaining the natural ordering of the keys(i.e name)
        // since we did not provide any comparator during Map creation time
//       The TreeMap, on the other hand, completely ignores the order in which entries come in.
//       It re-orders them using String.compareTo(key1, key2), because the key type is String and no comparator was supplied.
//       Hence the apparent “unsorted” output.
        TreeMap<String, Integer> treeMapByYrsOfExp = data.stream()
                .filter(e -> e.getYearsOfExp() > 10)
                .sorted(Comparator.comparingInt(EmplooyeeData::getYearsOfExp))
                .collect(toMap(EmplooyeeData::getName, EmplooyeeData::getYearsOfExp, (v1, v2) -> v2, TreeMap::new));

        //LinkedHashMap maintains and preserve the insertion order. so the sorted method result will be added into output map in sorted order itself
        //So the LinkedHashMap looks “sorted by years” only because you happen to insert in that order.
        //LinkedHashMap itself never sorts; it just remembers arrival order.
        LinkedHashMap<String, Integer> linkedHashMapByYrsOfExp = data.stream()
                .filter(e -> e.getYearsOfExp() > 10)
                .sorted(Comparator.comparingInt(EmplooyeeData::getYearsOfExp))
                .collect(toMap(EmplooyeeData::getName, EmplooyeeData::getYearsOfExp, (v1, v2) -> v2, LinkedHashMap::new));

        System.out.println("treeMapByYrsOfExp :: "+ treeMapByYrsOfExp);
        System.out.println("linkedHashMapByYrsOfExp :: "+ linkedHashMapByYrsOfExp);

        ///////////////////////////////////////////////////////////////////////////

        //using the custom comparator in treemap for custom object sorting or we can also implement comparable interface in the EmployeeData class
        //to sort the custom object key using treemap, the thenComparing comes into picture when there is same yearofexp of two object/employee
        // in that case the comparator return 0 and then we again check with employee name and sort the data using name property.
        TreeMap<EmplooyeeData,String> empDataByDept = data.stream()
                .collect(toMap(
                        Function.identity(),
                        EmplooyeeData::getName,
                        (e1,e2) -> e2,
                        () -> new TreeMap<>(
                                Comparator.comparingInt(EmplooyeeData::getYearsOfExp).reversed()
                                        .thenComparing(EmplooyeeData::getName)
                        )
                ));

        System.out.println("empDataByDept :: " +empDataByDept);

        // When a sorting the map which is having Integer (built-in class as the key)
        Map<Integer, String> numMap = new HashMap<>();
        numMap.put(1, "I");
        numMap.put(4, "IV");
        numMap.put(5, "V");
        numMap.put(9, "IX");
        numMap.put(10, "X");
        numMap.put(40, "XL");
        numMap.put(50, "L");
        numMap.put(90, "XC");
        numMap.put(100, "C");
        numMap.put(400, "CD");
        numMap.put(500, "D");
        numMap.put(900, "CM");
        numMap.put(1000, "M");

        Map<Integer,String> sortedByKeys =  numMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->v2, LinkedHashMap::new));
        System.out.println(sortedByKeys);


        TreeMap<Integer, String> treeMapDsc = numMap.entrySet().stream()
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (v1, v2) -> v2,
                                () -> new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed())
                        )
                );
        System.out.println(treeMapDsc);




    }

}
