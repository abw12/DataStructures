package Java8.StreamAPI.PracSession1;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Order {

    private Integer orderId;
    private Integer customerId;
    private Date orderDate;
    private Double orderAmount;

    public Order() {
    }

    public Order(Integer orderId, Integer customerId, Date orderDate, Double orderAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(customerId, order.customerId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(orderAmount, order.orderAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderDate, orderAmount);
    }
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
                '}';
    }

    public static List<Order> getDummyOrders() {
        return Arrays.asList(
            // Orders for customer 1 (John Smith)
            new Order(101, 1, Date.valueOf("2025-07-15"), 250.0),
            new Order(102, 1, Date.valueOf("2025-08-01"), 175.50),

            // Orders for customer 2 (Maria Garcia)
//            new Order(103, 2, Date.valueOf("2025-07-20"), 340.25),
//            new Order(104, 2, Date.valueOf("2025-08-02"), 120.75),

            // Orders for customer 3 (David Kim)
            new Order(105, 3, Date.valueOf("2025-07-18"), 420.00),
//            new Order(106, 3, Date.valueOf("2025-08-03"), 85.99),

            // Orders for customer 4 (Sarah Johnson)
            new Order(107, 4, Date.valueOf("2025-07-22"), 199.99),
            new Order(108, 4, Date.valueOf("2025-08-04"), 240.50),

            // Orders for customer 5 (James Williams)
            new Order(109, 5, Date.valueOf("2025-07-25"), 310.75),
            new Order(110, 5, Date.valueOf("2025-08-05"), 150.25),

            // Orders for customer 6 (Lisa Brown)
            new Order(111, 6, Date.valueOf("2025-07-19"), 275.00),
            new Order(112, 6, Date.valueOf("2025-08-03"), 195.75),

            // Orders for customer 7 (Robert Taylor)
            new Order(113, 7, Date.valueOf("2025-07-27"), 360.50),
            new Order(114, 7, Date.valueOf("2025-08-04"), 210.25),

            // Orders for customer 8 (Jennifer Miller)
            new Order(115, 8, Date.valueOf("2025-07-30"), 140.99),
//            new Order(116, 8, Date.valueOf("2025-08-05"), 280.50),

            // Orders for customer 9 (Michael Davis)
            new Order(117, 9, Date.valueOf("2025-07-16"), 390.00),
            new Order(118, 9, Date.valueOf("2025-06-16"), 290.00),
            new Order(119, 9, Date.valueOf("2025-08-01"), 225.75)

            // Orders for customer 10 (Emily Wilson)
//            new Order(119, 10, Date.valueOf("2025-07-24"), 170.25),
//            new Order(120, 10, Date.valueOf("2025-08-07"), 320.00)
        );
    }
}
