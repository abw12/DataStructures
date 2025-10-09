package GRASP;

public class RideService {

    private final DriverRepository driverRepository;
    private final FareCalculator fareCalculator;
    private final NotificationService notificationService;

    public RideService(DriverRepository driverRepo, FareCalculator fareCalculator, NotificationService notifier) {
        this.driverRepository = driverRepo;
        this.fareCalculator = fareCalculator;
        this.notificationService = notifier;
    }

    public Ride bookRide(Rider rider, String pickup, String drop) {
        Driver driver = driverRepository.findNearestAvailable(pickup);
        if (driver == null) throw new RuntimeException("No drivers available!");

        Ride ride = new Ride(rider, driver, pickup, drop);
        driver.setAvailability(false);
        notificationService.notifyDriver(driver, "New ride assigned!");
        return ride;
    }

    public void completeRide(Ride ride) {
        double fare = fareCalculator.calculateFare(ride);
        ride.markCompleted(fare);
        notificationService.notifyRider(ride.getRider(), "Your fare is ₹" + fare);
    }


}
