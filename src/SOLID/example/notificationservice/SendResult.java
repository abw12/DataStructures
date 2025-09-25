package SOLID.example.notificationservice;

public record SendResult(boolean success, String details) {
    public static SendResult ok(String d) {
        return new SendResult(true,d);
    }
    public static  SendResult fail(String d){
        return new SendResult(false,d);
    }
}
