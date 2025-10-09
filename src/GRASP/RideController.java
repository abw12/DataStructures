package GRASP;

//Controller principle: handles external events, delegates to domain/service
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService){
        this.rideService=rideService;
    }

    public void handleBookRide(Rider rider,String pickup,String drop){
        Ride ride = rideService.bookRide(rider,pickup,drop);
        System.out.println("Ride booked: " + ride);
    }

    public void handleCompleteRide(Ride ride) {
        rideService.completeRide(ride);
    }

}
