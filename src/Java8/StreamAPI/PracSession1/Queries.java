package Java8.StreamAPI.PracSession1;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Queries {

    public static void main(String[] args) {
        List<Customer> customers = Customer.getDummyCustomers();
        List<Order> orders = Order.getDummyOrders();
//      1.List the customer name and the corresponding order IDs for each customer who has placed an order.
        Map<Integer, String> custnameAndIdMap = customers.stream().collect(toMap(Customer::getCustomerId, Customer::getName));
        Map<Integer,Integer> filteredOrderData = orders.stream()
                .filter(order -> custnameAndIdMap.containsKey(order.getCustomerId()))
                .collect(toMap(Order::getCustomerId,Order::getOrderId));
    }
}
