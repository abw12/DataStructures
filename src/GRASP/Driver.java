package GRASP;

import java.util.Objects;

//Information Expert (holds state related to the driver itself.)
//Driver is not a good record candidate since its state changes after creation( mutable object as its availability changes)
public class Driver{

    private final String name;
    private final int mobNum;
    private final String location;
    private boolean availability;

    public Driver(String name, int mobNum, String location, boolean availability) {
        this.name = name;
        this.mobNum = mobNum;
        this.location = location;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public int getMobNum() {
        return mobNum;
    }

    public String getLocation() {
        return location;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return mobNum == driver.mobNum && availability == driver.availability && Objects.equals(name, driver.name) && Objects.equals(location, driver.location);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, mobNum, location, availability);
    }
}
