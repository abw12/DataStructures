package Java8;

import java.util.List;

public class ReduceMethodExample {

    static class User{
        private String name;
        private int age;

        private Double salary;

        private String dept;

        public User(String name, int age,Double salary,String dept){
            this.name=name;
            this.age=age;
            this.salary=salary;
            this.dept=dept;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Double getSalary() {
            return salary;
        }

        public String getDept() {
            return dept;
        }
    }

    public static void main(String[] args) {
//    syntax:
//        reduce(identity,accumulator function);
//        reduce(identity,accumulator function,combiner);

//        identity : it's the initial value and if the provided stream is empty then this value is returned by default
//        accumulator function : BinaryOperator<T> functional interface , a function that takes two parameters: a partial result
//                               of the reduction operation and the next element of the stream.
//        combiner: a function used to combine the partial result of the reduction operation when the reduction is parallelized
//                  or when there's a mismatch between the types of the accumulator arguments and the types of the accumulator implementation.

        //whenever we create anything using .of it is unmodifiable (immutable)
        List<Integer> nums = List.of(12,3,4,56,8,11,10,70);

        int sum = nums.stream().reduce(0,(partialResult,element) -> partialResult + element);
        int sum2 = nums.stream().reduce(0, Integer::sum); //similar thing with method reference
        System.out.println(sum);

        Integer productOfNumList = nums.stream().reduce(1, (partialResult, nextEl) -> partialResult * nextEl);
        System.out.println(productOfNumList);

        List<String> ch = List.of("a","b","w","12");
        String result = ch.stream().reduce("",(partialResult,element) -> partialResult + element);
        System.out.println(result);

        //
        List<User> users = List.of(new User("abhishek",25,758000.30,"Comps"),
                new User("siddhant",26,450009.60,"civil"),
                new User("abhijit",30,450009.60,"comps"),
                new User("samiksha",25,490009.60,"civil"),
                new User("rakishta",27,750002.67,"comps"),
                new User("mrin",28,650009.98,"civil"));
        //here we'll get the error since there is the mismatch in types ,the 2nd argument in accumulator function is of type user object
        //and in the accumulator implementation we are trying to add the partial value with a integer value so therefor compiler will not able
        // to identify the type operation need to be performed.
//        users.stream().reduce(0,(partialAge,user)->partialAge + user.getAge());
//        We can fix this issue by using a combiner:

        int sumOfAges= users.stream().reduce(0,(partialAge,user)->partialAge + user.getAge(),Integer::sum);
        //third parameter is the combiner Binary operator function (here used as method reference)
        System.out.println(sumOfAges);


        //example to find maxAge from the given list of users
        Integer maxAge = users.stream()
                .reduce(0,(partialAge,user) -> partialAge < user.getAge() ? user.getAge() : partialAge,Integer::max);
        System.out.println("MaxAge: " +maxAge);

        //example of using filter map and reduce together
        //calculate the avg salary of all users in dept comps
        //there are different reduction operator -> The average is a special case of a reduction.
        Double avgCompsSalary =users.stream()
                .filter(user -> user.getDept().equals("comps"))
                .map(User::getSalary)
                .mapToDouble(i -> i)
                .average()
                .getAsDouble();
        System.out.println(avgCompsSalary);




    }
}
