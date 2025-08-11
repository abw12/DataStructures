package Java8.StreamAPI.PracSession1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Queries {

    private static Map<String,List<Integer>> retrieveCustomerNameWithOrders(List<Customer> customers, List<Order> orders){
        //1. naive approach using two itermediate map and a loop to store result in final map
        //Map<Integer, String> custnameAndIdMap = customers.stream().collect(toMap(Customer::getCustomerId, Customer::getName));
//        Map<Integer,List<Integer>> filteredOrderData = orders.stream()
//                .filter(order -> custnameAndIdMap.containsKey(order.getCustomerId()))
//                .collect(groupingBy(Order::getCustomerId,TreeMap::new, Collectors.mapping(Order::getOrderId,toList())));
//
//        //store the result in map
//        Map<String,List<Integer>> finalResult = new HashMap<>();
//        for(Map.Entry<Integer,List<Integer>> entry:filteredOrderData.entrySet()){
//            if(custnameAndIdMap.containsKey(entry.getKey())){
//                String customerName = custnameAndIdMap.get(entry.getKey());
//                finalResult.put(customerName, entry.getValue());
//            }
//        }
//        return finalResult;

        //2. using the single pass streaming chain using 1 intermediate map.
        Map<Integer,String> custIdToName = customers.stream().collect(toMap(Customer::getCustomerId,Customer::getName));

        Map<String, List<Integer>> rsult = orders.stream()
                .filter(order -> custIdToName.containsKey(order.getCustomerId()))
                .collect(Collectors.groupingBy(
                        order -> custIdToName.get(order.getCustomerId()),
                        Collectors.mapping(Order::getOrderId, Collectors.toList())
                ));
        return rsult;
    }

    private static Map<String, Double> retrieveCustomerWithHighestSpend(List<Customer> customers,List<Order> orders){
        Map<Integer,String> custIdToName = customers.stream().collect(toMap(Customer::getCustomerId,Customer::getName));

        Map<String, Double> highestSpendsPerCustomer = orders.stream()
                .filter(order -> custIdToName.containsKey(order.getCustomerId()))
                .collect(groupingBy(
                                order -> custIdToName.get(order.getCustomerId()),
                                Collectors.summingDouble(Order::getOrderAmount)
                        )
                );

        return highestSpendsPerCustomer;
    }

    private static Optional<Map.Entry<String,Double>> maxSpendingCustomer(List<Customer> customers,List<Order> orders){
        Map<Integer,String> custIdToName = customers.stream().collect(toMap(Customer::getCustomerId,Customer::getName));
        Optional<Map.Entry<String, Double>> maxSpendingCustomer = orders.stream()
                .filter(order -> custIdToName.containsKey(order.getCustomerId()))
                .collect(groupingBy(
                                order -> custIdToName.get(order.getCustomerId()),
                                Collectors.summingDouble(Order::getOrderAmount)
                        )
                ).entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue));

        return maxSpendingCustomer;
    }

    private static Map<String, Double> retrieveMaxOrderPerCustomer(List<Customer> customers,List<Order> orders){
        Map<Integer,String> custIdToName = customers.stream().collect(toMap(Customer::getCustomerId,Customer::getName));

        Map<String, Double> highestSpendsPerCustomer = orders.stream()
                .filter(order -> custIdToName.containsKey(order.getCustomerId()))
                .collect(groupingBy(
                                order -> custIdToName.get(order.getCustomerId()),
                                Collectors.collectingAndThen(maxBy(Comparator.comparingDouble(Order::getOrderAmount)),
                                        order -> order.map(Order::getOrderAmount).orElse(0.0)
                                )
                        )
                );
        return highestSpendsPerCustomer;
    }
    public static void main(String[] args) {
        List<Customer> customers = Customer.getDummyCustomers();
        List<Order> orders = Order.getDummyOrders();
//      1.List the customer name and the corresponding order IDs for each customer who has placed an order.
        Map<String, List<Integer>> customerNameWithOrderId = retrieveCustomerNameWithOrders(customers, orders);
        System.out.println("Final Result with Customer Name and OrderId :: " + customerNameWithOrderId);
//      7 Customers with the highest total order amount: Find the customer(s) who have the highest total amount spent on orders.  (This is a bit more challenging!)
        Map<String, Double> totalSpendPerCustomer = retrieveCustomerWithHighestSpend(customers, orders);
        System.out.println("Total Spend per customer  :: " + totalSpendPerCustomer);

        Optional<Map.Entry<String,Double>> max = maxSpendingCustomer(customers,orders);
        System.out.println(max.get());

        Map<String, Double> maxOrderPerCustomer = retrieveMaxOrderPerCustomer(customers, orders);
        System.out.println("Max Order per Customer List :: " + maxOrderPerCustomer);


    }
}
