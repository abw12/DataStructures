package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gpay{



//    @Override
//    public String doPayment(String source, String dest, long amount) {
//        String s= UPIPayment.datePattern("yyyy-MM-dd");
//        return null;
//    }

    public static void main(String[] args) {
        //this is how we write the functional interface instance using the lambda expression
        UPIPayment payments=(source,dest,amount) -> {
            StringBuilder output =new StringBuilder("Source " + source + " destination " + dest + " amount "+ amount);
            return output.toString();
        };

        System.out.println(payments.doPayment("Abhishek","Vedant","1200"));


        Function<String,String> func = (input) -> "output: "+ input;
        System.out.println(func.apply("abhishek"));

        List<Integer> list = Arrays.asList(23,5,4,7,3,2,1,10,19,9);


        list.stream().filter(input -> input > 5).sorted().forEach(System.out::println); //System.out::println is shorthand for lambda experssion which is know as method reference(::)

        //example of instance method reference
        Gpay test=new Gpay();
        list.stream().filter(input -> input > 10).sorted().forEach(test::printElement);


        //when to map & flatmap
        List<Employee> employee = Stream.of(new Employee("Abhishek",123456,"Virar",Arrays.asList("abhsiehk@gmail.com","wasave@gmail.com")),
                        new Employee("Vedant",23456,"Andheri",Arrays.asList("vedant@gmail.com","jangya@yahoo.com","chindkya@hotmail.com")),
                        new Employee("Sarang",33333,"Delhi",Arrays.asList("sarang@gmail.com","seethji@amazon.com")),
                        new Employee("Raki",898989,"Delhi",Arrays.asList("rak@gmail.com","raki@gmail.com"))
                        ).collect(Collectors.toList());

        //use map() for one-to-one relations like phnNummber is just string so we can use map over here to get all phnNumbers
        List<Double> numbers= employee.stream().map(Employee::getPhnNo).collect(Collectors.toList());
        System.out.println(numbers);

        //use flapmap() for one-to-many relations like in case of emails as emails are List<String> to get all emails in single format of list of string we can use flatmap
        List<String> emails= employee.stream().flatMap(User -> User.getEmails().stream()).collect(Collectors.toList());
        System.out.println(emails);

        ///covert this emails again to List<List<String>>
        Map<String, List<Employee>> collect = employee.stream().collect(Collectors.groupingBy(Employee::getAddress));
        System.out.println("Collect " + collect);




        //if we use map() for emails then it will be shown in seperate list<List<String> format for each users
        List<List<String>> emailsMap= employee.stream().map(Employee::getEmails).collect(Collectors.toList());
        System.out.println(emailsMap);

        //streams vs parallel streams
//        IntStream.rangeClosed(1,10).forEach(i->System.out.println(Thread.currentThread().getName() + " : "+ i));
//        System.out.println("=====================");
//        IntStream.rangeClosed(1,10).parallel().forEach(i->System.out.println(Thread.currentThread().getName() + " : "+ i));

        System.out.println("Available Cores:" + Runtime.getRuntime().availableProcessors());
    }

    public void printElement(int i){
        System.out.println(i);
    }





}
