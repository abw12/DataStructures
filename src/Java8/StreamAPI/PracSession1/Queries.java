package Java8.StreamAPI.PracSession1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

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

    public static void main(String[] args) {
        List<Customer> customers = Customer.getDummyCustomers();
        List<Order> orders = Order.getDummyOrders();
//      1.List the customer name and the corresponding order IDs for each customer who has placed an order.
        Map<String, List<Integer>> customerNameWithOrderId = retrieveCustomerNameWithOrders(customers, orders);
        System.out.printf("Final Result with Customer Name and OrderId :: " + customerNameWithOrderId);


    }
}
