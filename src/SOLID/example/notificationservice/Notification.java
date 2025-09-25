package SOLID.example.notificationservice;

public record Notification(Channel channel,String to, String subject, String body, byte[] attachment) {
}
