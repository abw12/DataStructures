package GRASP;

import java.util.ArrayList;
import java.util.List;

//Indirection: abstracts persistence — controller/service don’t care how drivers are stored.
public class DriverRepository {

    private final List<Driver> drivers = new ArrayList<>();

    public void add(Driver d){
        drivers.add(d);
    }

    public Driver findNearestAvailable(String pickup){
        // simplified — just return first available
        return drivers.stream().filter(Driver::isAvailability).findFirst().orElse(null);
    }
}
