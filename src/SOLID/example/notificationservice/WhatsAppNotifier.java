package SOLID.example.notificationservice;

import java.util.Objects;

public class WhatsAppNotifier implements Notifier{

    private final String apiUrl;
    private final WhatsAppClient client;
    private final Validator validator;

    public WhatsAppNotifier(String apiUrl, WhatsAppClient client,Validator validator){
        this.apiUrl= Objects.requireNonNull(apiUrl);
        this.client=Objects.requireNonNull(client);
        this.validator=Objects.requireNonNull(validator);
    }

    @Override
    public Channel channel() {
        return Channel.WHATSAPP;
    }

    @Override
    public SendResult send(Notification n) {
        validator.validate(n);
        return client.postMessage(apiUrl,n.to(),n.body());
    }
}
