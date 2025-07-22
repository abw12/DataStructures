package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class BiFunctionExample {

    //More practical use case of the BiFunction in the reduce method
    //suppose we hvae a stream of products and cartsummary
    // --- Product Class (Our Stream Element Type: T) ---
    record Product(String name,int quantity, double price){}
    record CartSummary(int totalItems, double totalCost){}

    private static void BiFunctionReduceExample() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1, 1200.0),
                new Product("Mouse", 2, 25.0),
                new Product("Keyboard", 1, 75.0),
                new Product("Monitor", 2, 250.0)
        );

        // U identity : The initial CartSummary before processing any products
        CartSummary initialCartSummery = new CartSummary(0, 0.0);

        //BiFunction<CartSummary,Product,CartSummary>: accumulator function
        //This is where our BiFunction works on different types (CartSummary, Product)
        // to produce a CartSummary
        BiFunction<CartSummary, Product, CartSummary> accumulator =
                (currentSummary, product) -> {
                    System.out.println("Accumulating: Current " + currentSummary.totalItems() + " items, " + String.format("%.2f", currentSummary.totalCost()) +
                            " with Product: " + product.name() + " (Qty: " + product.quantity() + ", Price: " + String.format("%.2f", product.price()) + ")");
                    return new CartSummary(
                            currentSummary.totalItems() + product.quantity(),
                            currentSummary.totalCost() + (product.quantity() * product.price())
                    );
                };

        //BiOperator<CartSummary> : combiner
        // // Used for parallel streams. It combines two CartSummary results into one.
        // Note: BinaryOperator is a specialized BiFunction where all types (T, U, R) are the same (U).
        BinaryOperator<CartSummary> combiner = (summary1,summary2) -> {
            System.out.println("Combining partial results: " + summary1 + " and " + summary2);
            return new CartSummary(summary1.totalItems() + summary2.totalItems(),
                    summary1.totalCost() + summary2.totalCost());
        };

        // use all these functional interfaces lambda function in the reduce method below to calculate the cartsummary
        CartSummary finalCartSummary = products.stream().reduce(initialCartSummery,accumulator,combiner);
        System.out.println("\nFinal Cart Summary: " + finalCartSummary);

        // in-line lambda function which can reduce the code size
        CartSummary finalCartSummaryCompact = products.stream().reduce(
                new CartSummary(0,0.0), //identity (initial value)
                (summary,product) -> new CartSummary( summary.totalItems() + product.quantity(), //BiFUnction
                        summary.totalCost() + (product.quantity()) * product.price()
                ),
                (summary1,summary2) -> new CartSummary(summary1.totalItems() + summary2.totalItems(), // combiner (BiOperator)
                        summary1.totalCost()+summary2.totalCost()
                )
        );

        System.out.println("Final Cart Summary (compact): " + finalCartSummaryCompact);


    }

    public static void main(String[] args) {
        //The BiFunction interface allows us to use parameters of different types, with a return value of a third type.
        List<Integer> list1 = Arrays.asList(10,20,30);
        List<String> list2 = Arrays.asList("a","b","c");

//        List<String> result = new ArrayList<>();
//        for(int i=0;i<list1.size();i++){
//            result.add(list1.get(i) + list2.get(i));
//        }
        //calling the below generalize method listCombiner
        //here we passing two list with diff data type and return type is string
        List<String> result =listCombiner(list1,list2,(num,letter) -> num + letter);
        System.out.println(result);

        //we can also pass the two diff data type as param and the return is also diff from both of them
        List<Double> list3 = Arrays.asList(10.6,20.9,30.10);
        List<Float> list4 = Arrays.asList(20.9f,30f,27f); //when we mention f it specifically take float else it will consider decimal value as double

        //return type is another  diff data type
        List<Boolean> result2 = listCombiner(list3,list4,(doubleNumber,floadtNumber) -> doubleNumber > floadtNumber);
        System.out.println(result2);

        //use of BiFunction in the real-world scenario example with reduce method
        BiFunctionReduceExample();

    }
    //generalize the above algorithm to combine two list into elements into third
    private static <T,U,R> List<R> listCombiner(List<T> list1, List<U> list2 , BiFunction<T,U,R> combiner){
        List<R> result =new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            result.add(combiner.apply(list1.get(i),list2.get(i)));
        }
        return result;
    }
}
