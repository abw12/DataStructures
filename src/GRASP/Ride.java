package GRASP;

//Information Expert (holds state and logic related to the ride itself.)
public class Ride {

    private final Rider rider;
    private final Driver driver;
    private final String pickup;
    private final String drop;
    private boolean completed;
    private double fare;

    public Ride(Rider rider,Driver driver,String pickup,String drop){
        this.rider = rider;
        this.driver = driver;
        this.pickup = pickup;
        this.drop = drop;
        this.completed = false;
    }

    public void markCompleted(double fare){
        this.completed = true;
        this.fare=fare;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDrop() {
        return drop;
    }

    public boolean isCompleted() {
        return completed;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rider=" + rider +
                ", driver=" + driver +
                ", pickup='" + pickup + '\'' +
                ", drop='" + drop + '\'' +
                ", completed=" + completed +
                ", fare=" + fare +
                '}';
    }
}
