package SOLID.example.notificationservice;

public class EmailNotifier implements Notifier{

    private final String apiUrl;
    private final EmailClient client;
    private final Validator emailValidator;

    public EmailNotifier(String apiUrl, EmailClient client,Validator validator){
       this.apiUrl=apiUrl;
       this.client=client;
       this.emailValidator=validator;
    }

    @Override
    public Channel channel() {
        return Channel.EMAIL;
    }

    @Override
    public SendResult send(Notification n) {
        emailValidator.validate(n);
        return client.sendMail(this.apiUrl,n.to(),n.subject(),n.body(),n.attachment());
    }
}
