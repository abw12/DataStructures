package SOLID.example.notificationservice;

public interface Notifier {
    Channel channel();
    SendResult send(Notification n);
}
