package GRASP;
//Pure Fabrication — cross-cutting concern (notifications).
public class NotificationService {
    public void notifyDriver(Driver driver, String msg) {
        System.out.println("Notify Driver " + driver.getName() + ": " + msg);
    }

    public void notifyRider(Rider rider, String msg) {
        System.out.println("Notify Rider " + rider.name() + ": " + msg);
    }
}
