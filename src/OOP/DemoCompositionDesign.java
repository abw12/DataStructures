package OOP;

import java.math.BigDecimal;
import java.util.Objects;

// Behaviour abstraction
interface Engine{
    String type(); //eg. petrol,diesel,ev
    int displacementC();
    int horsePower();
}

final class PetrolEngine implements Engine{
    private final int cc;
    private final int hp;

    public PetrolEngine(int cc,int hp){
        this.cc=cc;
        this.hp=hp;
    }

    @Override
    public String type() {
        return "Petrol";
    }

    @Override
    public int displacementC() {
        return this.cc;
    }

    @Override
    public int horsePower() {
        return this.hp;
    }
}

final class ElectricMotor implements Engine{

    private final int hp;

    public ElectricMotor(int hp){
        this.hp = hp;
    }

    @Override
    public String type() {
        return "Electric Vehicle";
    }

    @Override
    public int displacementC() {
        return 0;
    }

    @Override
    public int horsePower() {
        return this.hp;
    }
}

interface PricingPolicy{
    BigDecimal priceFor(Specifications specs);
}

final class SimplePricing  implements PricingPolicy{

    @Override
    public BigDecimal priceFor(Specifications specs) {
        BigDecimal base = new BigDecimal("300000");
        BigDecimal power = BigDecimal.valueOf(specs.engine().horsePower() * 1000L);
        return base.add(power);
    }
}
//// --- Data/Spec + Vehicle that composes behavior ---
//Difference: With composition, behavior is plugged in. With inheritance, behavior is hardcoded into the class hierarchy.
record Specifications(String brand,String model,Engine engine){
    //this is known as compact constructor introduced in java 17
    Specifications{
        Objects.requireNonNull(brand); //we can directly use the parameter fields of the in compact constructor  instead of doing this.brand which will give the compile time error
        Objects.requireNonNull(model);
        Objects.requireNonNull(engine);
    }
}
//Here, Vehicle is just a container of behaviors.
final class Vehicle2{
    //weeker association
    private final Specifications spec; //this is basically demonstrating the aggregation form (the similar form as composition in association concept of the OOP)
    private final PricingPolicy pricing;

    public Vehicle2(Specifications spec, PricingPolicy pricing){ // spec and pricing are just received from outside (constructor injection).
        this.spec = Objects.requireNonNull(spec);
        this.pricing = Objects.requireNonNull(pricing);
    }

    public String brand(){
        return spec.brand();
    }

    public String model(){
        return spec.model();
    }
    public Engine engine(){
        return spec.engine();
    }

    public BigDecimal price(){
        return pricing.priceFor(spec);
    }
    @Override public String toString() {
        return spec.brand() + " " + spec.model() + " (" +
                engine().type() + ", " + engine().horsePower() + "hp) ₹" + price();
    }
}

//If we wanted true Composition than above vehicle2 class can be changed to something like below
// here Engine is constructed and part-of the vehicle3 object itself.
final class Vehicle3 {

    private final Engine engine;
    private final String brand;
    private final String model;

    public Vehicle3(String brand,String model){
        this.brand=brand;
        this.model=model;
        this.engine = new ElectricMotor(120); // strong ownership (composition => part-of vehicle3)
    }

    public Engine engine() { return engine; }
}

        /*Why this is powerful

        To add a new engine type or new pricing scheme, you compose a different implementation — no subclass explosion.

        You can change behavior at runtime (swap pricing, engines) → Open/Closed Principle.

        This plays very well with Dependency Injection (e.g., Spring) and testing (mock PricingPolicy).*/

        /*In the composition example, the relationship is:

        A Vehicle has a Specification.

        A Specification has an Engine.

        A Vehicle uses a PricingPolicy to compute price.

        This example is demonstrating the aggregation (weeker form of association) in real-world project.
        Since the Specification and PricingPolicy can live independently elsewhere if the Vehicle2 object is destroyed.
        This is more closer to aggregation example then composition.
        */
public class DemoCompositionDesign {

    public static void main(String[] args) {
        Vehicle2 skoda = new Vehicle2(
                new Specifications("Skoda", "Kusaq", new PetrolEngine(1498,150)),
                new SimplePricing()
        );
        /*Only one Vehicle class.
        Variations are handled by plugging different engines or pricing policies.
        No class explosion.*/
        Vehicle2 tata = new Vehicle2(
                new Specifications("TATA", "Nexon", new ElectricMotor(125)),
                new SimplePricing()
        );
        Vehicle2 triumph = new Vehicle2(
                new Specifications("Triumph", "Speed 400x", new PetrolEngine(398,60)),
                new SimplePricing()
        );

        System.out.println(skoda);
        System.out.println(triumph);
        System.out.println(tata);
    }
}
