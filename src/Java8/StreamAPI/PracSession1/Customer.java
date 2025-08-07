package Java8.StreamAPI.PracSession1;

import java.util.Arrays;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private Integer customerId;
    private String city;

    public Customer() {}

    public Customer(String name, String email, String phoneNumber, Integer customerId, String city) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.customerId = customerId;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", customerId=" + customerId +
                ", city='" + city + '\'' +
                '}';
    }

    public static List<Customer> getDummyCustomers() {
        return Arrays.asList(
            new Customer("John Smith", "john.smith@example.com", "555-123-4567", 1, "New York"),
            new Customer("Maria Garcia", "maria.garcia@example.com", "555-234-5678", 2, "Los Angeles"),
            new Customer("David Kim", "david.kim@example.com", "555-345-6789", 3, "Chicago"),
            new Customer("Sarah Johnson", "sarah.j@example.com", "555-456-7890", 4, "Houston"),
            new Customer("James Williams", "james.w@example.com", "555-567-8901", 5, "Phoenix"),
            new Customer("Lisa Brown", "lisa.brown@example.com", "555-678-9012", 6, "Philadelphia"),
            new Customer("Robert Taylor", "robert.t@example.com", "555-789-0123", 7, "San Antonio"),
            new Customer("Jennifer Miller", "jennifer.m@example.com", "555-890-1234", 8, "San Diego"),
            new Customer("Michael Davis", "michael.d@example.com", "555-901-2345", 9, "Dallas"),
            new Customer("Emily Wilson", "emily.w@example.com", "555-012-3456", 10, "San Jose")
        );
    }
}
