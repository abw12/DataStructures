package Java8.StreamAPI;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// For Questions 2, 4, 5, 6 you would need classes like these:

class Product {
    String name;
    String category;
    double price;
    boolean available; // Added for Q2

    public Product(String name, String category, double price, boolean available) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; } // For Q2

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + ", available=" + available + '}';
    }
}

class Order {
    String customerName;
    List<Item> items;

    public Order(String customerName, List<Item> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public String getCustomerName() { return customerName; }
    public List<Item> getItems() { return items; }
}

class Item {
    String productName;
    double price;

    public Item(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() { return productName; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Item{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}

class Empl {
    String name;
    String department;
    double salary;

    public Empl(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}


public class PracticeStreamAPI {

    public static void main(String[] args) {
        //1) Given a list of integers, find the sum of the squares of all numbers greater than 10.
        List<Integer> numList = Arrays.asList(2,9,10,34,20,3,5,17);
        int sum = numList.stream()
                .filter(n -> n > 10)
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("sum of the squares of all numbers greater than 10." + sum);

        //2)You have a list of Product objects. Filter out the products that are out of stock (assume a boolean isAvailable()
        // method exists in the Product class), convert the names of the available products to uppercase,
        // and collect them into a Set to ensure uniqueness.

        List<Product> products = Stream.of(
                new Product("Pixel 7 pro","Smartphone",84000,true),
                new Product("Mac book 4 pro","Laptop",210000,true),
                new Product("Mac book 4 pro","Laptop",190000,true),
                new Product("Mac book 2 pro","Laptop",170000,true),
                new Product("PS5","Gaming console",84000000,true)
        ).collect(Collectors.toList());

        Set<String> avlProduct = products.stream().filter(Product::isAvailable).map(p -> p.getName().toUpperCase()).collect(Collectors.toSet());
        System.out.println("Available Products :: " + avlProduct);

        //sorting the map in ascending order

        Map<String,Double> orderProducts = products.stream().filter(p -> p.isAvailable() && p.getPrice() > 150000)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toMap(Product::getName,Product::getPrice,(k1,k2) -> k1,LinkedHashMap::new));

        for(Map.Entry<String,Double> entry : orderProducts.entrySet()){
            System.out.println("Product: " + entry.getKey() + " " + "Price: " + entry.getValue());
        }

        //3) Given a list of strings, find the average length of strings that have a length greater than 5.
        List<String> words = List.of("apple", "banana", "cat", "elephant", "dog", "programming");

        OptionalDouble average = words.stream()
                .filter(s -> s.length() > 5) // Intermediate: Keep strings longer than 5
                .mapToInt(String::length) // Intermediate: Map strings to their lengths (IntStream)
                .peek(System.out::println)
                .average();
        //using the summary statistic method
        IntSummaryStatistics stats = words.stream()
                .filter(s -> s.length() > 5) // Intermediate: Keep strings longer than 5
                .mapToInt(String::length)    // Intermediate: Map strings to their lengths (IntStream)
                .summaryStatistics();        // Terminal: Generate statistics

        if(average.isPresent())
            System.out.println("average length of strings that have a length greater than 5 => " + average.getAsDouble());


        //4) You have a list of Order objects. Each Order has a customerName (String) and a list of Item objects (List<Item>).
        // Each Item has a productName (String) and price (double).
        // Calculate the total amount spent by each customer and return the result as a Map<String, Double>,
        // where the key is the customer name and the value is the total spent
        List<Order> orders = List.of(
                new Order("Alice", List.of(new Item("Laptop", 1200.00), new Item("Mouse", 25.00))),
                new Order("Bob", List.of(new Item("Keyboard", 75.00), new Item("Monitor", 300.00))),
                new Order("Alice", List.of(new Item("Book", 20.00), new Item("Laptop", 1200.00))),
                new Order("Charlie", List.of(new Item("Desk", 300.00)))
        );

        Map<String, Double> purchasedDetails = orders.stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.summingDouble(
                                        order -> order.getItems().stream().mapToDouble(Item::getPrice).sum()
                                )
                        )
                );
        System.out.println("Purchased Details :: " + purchasedDetails);

        //5) You have a list of Employee objects, each with a name (String), department (String), and salary (double).
        // Find the department with the highest average salary. Return the department name (String). Assume there is at least one employee.
        List<Empl> employees = List.of(
                new Empl("Alice", "Sales", 50000.0),
                new Empl("Bob", "IT", 70000.0),
                new Empl("Charlie", "Sales", 60000.0),
                new Empl("David", "IT", 75000.0),
                new Empl("Eve", "HR", 55000.0)
        );

        Map<String, Double> avgSalPerDept = employees.stream().collect(
                Collectors.groupingBy(Empl::getDepartment,
                        Collectors.averagingDouble(Empl::getSalary)
                )
        );

        String deptNameWithHighestAvgSal = avgSalPerDept.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("N/A");
        System.out.println("Dept name with highest avg salary :: "+ deptNameWithHighestAvgSal);

        //6) You have a list of Order objects, and each Order contains a list of LineItem objects.
        // Find a list of all unique products that have been ordered across all orders.
        List<Item> distinctItemsAcrossOrders = orders.stream()
                .flatMap(order -> order.getItems().stream()).distinct()
                .collect(Collectors.toList());
        System.out.println("distinctItemsAcrossOrders :: " + distinctItemsAcrossOrders);

        //same question is solved will different Data and showcasing the use of record
        record LineItem(String productName, int quantity) {} //introduces in java 14 and require java 17 records are immutable objects which are mostly used for creating DTOs/ pojo classes
        record Order(int orderId, List<LineItem> lineItems) {}

        List<Order> ordersList = Arrays.asList(
                new Order(1, Arrays.asList(new LineItem("Laptop", 1), new LineItem("Mouse", 2))),
                new Order(2, Arrays.asList(new LineItem("Keyboard", 1), new LineItem("Mouse", 1))),
                new Order(3, Arrays.asList(new LineItem("Laptop", 1), new LineItem("Monitor", 1)))
        );

        List<String> lineItemsList = ordersList.stream()
                .flatMap(
                        order -> order.lineItems().stream()
                                .map(LineItem::productName) //if you apply distinct over here it will be applied on each stream(LineItem list of an order) inside the flatmap
                )
                .distinct()
                .toList();

        System.out.println("lineItemsList :: " + lineItemsList);


    }
}
