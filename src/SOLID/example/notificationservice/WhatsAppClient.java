package SOLID.example.notificationservice;

public interface WhatsAppClient {
    SendResult postMessage(String apiUrl,String to, String body);
}

class FakeWhatsAppClient implements WhatsAppClient{

    @Override
    public SendResult postMessage(String apiUrl, String to, String body) {
        System.out.printf("POST %s | to=%s | body=%s%n", apiUrl, to, body);
        boolean ok = Math.random() > 0.2;
        return ok ? SendResult.ok("msg-id:123") : SendResult.fail("network error");
    }
}