package Java8.StreamAPI;


import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


    }

}
