package SOLID.example.notificationservice;

import java.util.Arrays;

public interface EmailClient {
    SendResult sendMail(String apiUrl,String to,String subject, String body, byte[] attachment);
}

class FakeEmailClient implements EmailClient{

    @Override
    public SendResult sendMail(String apiUrl, String to, String subject, String body, byte[] attachment) {
        System.out.printf("POST %s | to=%s | body=%s%n  | subject=%s%n  | attachment=%s%n", apiUrl, to, body,subject, Arrays.toString(attachment));
        boolean ok = Math.random() > 0.2;
        return ok ? SendResult.ok("msg-id:456") : SendResult.fail("network error");
    }
}
