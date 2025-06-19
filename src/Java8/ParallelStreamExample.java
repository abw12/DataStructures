package Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamExample {


    public static  List<ReduceMethodExample.User> getUsers(){
        List<ReduceMethodExample.User> dummyUsers = new ArrayList<>();
        for(int i=0 ; i < 1000 ; i++){
            String name = "user"+i;
            dummyUsers.add(new ReduceMethodExample.User(name,i, (double) new Random().nextInt(1000 * 100),"A"));
        }
        return dummyUsers;
    }

    public static void main(String[] args) {

        long start =0 ;
        long end = 0;

        //if we observe the result of both since sequential stream executes only on main thread the out is sequential like 1,2,3,4...99,100
        //and time taken is more than parallel
/*        start = System.currentTimeMillis();
        IntStream.range(1,100).forEach(x -> System.out.println("Sequential Stream: " + x));
        end= System.currentTimeMillis();
        System.out.println("Time Take by Sequential Stream : " + (end-start));*/

        //since parallel stream run on multiple thread so the output is randomly printed like 34,23,1,3,9,...100
        //time taken by the parallel stream is less than sequential stream
/*        start=System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach(x -> System.out.println("Parallel Stream: " +x));
        end=System.currentTimeMillis();
        System.out.println("Time Taken by Parallel Stream: " + (end-start));*/

        //if we print the thread name we can see the difference in both sequential and parallel stream
        //as parallel stream executes on different threads and the sequential thread execute on main thread only

//        IntStream.range(1,10).forEach(x -> System.out.println("Thread: " + Thread.currentThread().getName() + " : " + x));
//        System.out.println("=========================================================");
//        //parallel stream will execute few task on the ForkJoinPool.commonPool-worker thread if we haven't provided our own Executor pool
//        IntStream.range(1,10).parallel().forEach(x -> System.out.println("Thread: " + Thread.currentThread().getName() + " : " + x));


        ///to see the difference in how much time the parallel stream saves check below example result
        //here we are calculating the avg salary in dept A for 1000 users using sequential and parallel streams

        List<ReduceMethodExample.User> userList = getUsers();

        start = System.currentTimeMillis();
        double avgSalarySequential = userList.stream()
//                .filter(user -> user.getDept().equalsIgnoreCase("A"))
                .map(user -> user.getSalary())
                .mapToDouble(i -> i)
                .average()
                .getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Time Taken by Sequential Stream Calculation : " + (end - start) + " Avg. Salary is : " + avgSalarySequential);

        start = System.currentTimeMillis();
        double avgSalaryParallel = userList.parallelStream()
//                .filter(user -> user.getDept().equalsIgnoreCase("A"))
                .map(user -> user.getSalary())
                .mapToDouble(i -> i)
                .average()
                .getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Time Taken by Parallel Stream Calculation : " + (end - start) + " Avg. Salary is : " + avgSalaryParallel);


    }
}
