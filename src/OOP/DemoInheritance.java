package OOP;

import java.math.BigDecimal;
import java.util.Objects;

interface Vehicle {
    String getBrandName();
    String getModelName();
    BigDecimal getPrice();
}

abstract class BaseVehicle implements Vehicle {
    private final String brandName;
    private final String modelName;
    private final BigDecimal price; // immutable

    protected BaseVehicle(String brandName, String modelName, BigDecimal price) {
        this.brandName = Objects.requireNonNull(brandName);
        this.modelName = Objects.requireNonNull(modelName);
        this.price = Objects.requireNonNull(price);
    }

    @Override public String getBrandName() { return brandName; }
    @Override public String getModelName() { return modelName; }
    @Override public BigDecimal getPrice() { return price; }

    @Override public String toString() {
        return brandName + " " + modelName + " ₹" + price;
    }
}

final class Skoda extends BaseVehicle {
    public Skoda(String modelName, BigDecimal price) {
        super("Skoda", modelName, price);
    }
}

final class Triumph extends BaseVehicle {
    public Triumph(String modelName, BigDecimal price) {
        super("Triumph", modelName, price);
    }
}

public class DemoInheritance {
    public static void main(String[] args) {
        Vehicle skoda = new Skoda("Kushaq", new BigDecimal("1100000"));
        Vehicle triumph = new Triumph("Speed 400X", new BigDecimal("340000"));

        System.out.println(skoda);
        System.out.println(triumph);
    }
}
