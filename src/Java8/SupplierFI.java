package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierFI /*implements Supplier<String>*/ {

   /* @Override
    public String get() {
        return "Hello my name is abhishek";
    }*/

    public static void main(String[] args) {

//            SupplierFI supplierFI = new SupplierFI();
//            System.out.println(supplierFI.get());

        //this is not using th lambda expression
            Supplier<String> supplier = new Supplier<String>() {
                @Override
                public String get() {
                    return "I'm going to be rich in life!!";
                }
            };
        System.out.println(supplier.get());

            //directly using the lambda expression
        Supplier<String> supplierLambda = ()  -> "I''m A Software Developer!!";
        System.out.println(supplierLambda.get());

        //its use case is in the situations where we are trying to find some values in a collection or after filtering the data
        //and dat is not found then we can return the default value using a supplier
        //orElseGet(0)method accept the supplier as a parameter

//        List<String> list = Arrays.asList("abhi","wasave");
        List<String> list = Arrays.asList();

        //so if the list is empty then the orElseGet() method will be executed and our supplier will return the value
        System.out.println(list.stream().findAny().orElseGet(() -> "nothing found in list!"));


    }
}
