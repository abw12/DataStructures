package GRASP;

//Information Expert — it knows how to calculate fare because it has rate logic.
public class FareCalculator {

    private static final double BASE_FARE = 50;
    private static final double RATE_PER_KM = 12;

    public double calculateFare(Ride ride){
        double distance = DistanceUtil.estimate(ride.getPickup() , ride.getDrop());
        return BASE_FARE + distance * RATE_PER_KM;
    }
}
