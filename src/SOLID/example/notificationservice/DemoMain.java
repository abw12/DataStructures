package SOLID.example.notificationservice;

public class DemoMain {
    public static void main(String[] args) {
        NotificationService svc = getNotificationService();

        //Send one whatsapp notification
        Notification n = new Notification(Channel.WHATSAPP,"+919999888877", "Greetings", "Hello from composition world!", null);
        SendResult r = svc.send(n);
        System.out.println("Result: " + r);

        //send one email notification
        Notification en = new Notification(Channel.EMAIL,"wasave@gmail.com","Learning","Hello from enthusiast Developer",null);
        SendResult re = svc.send(en);
        System.out.println("Result: " + re);
    }

    private static NotificationService getNotificationService() {
        TemplateEngine template = new SimpleTemplateEngine();
        AuditLogger audit = new FileAuditLogger("audit.log");

        NotificationService svc = new NotificationService(template,audit);

        //Wire WhatsApp
        WhatsAppClient whatsAppClient = new FakeWhatsAppClient();
        Validator waValidator = new WhatsAppValidator();
        Notifier wa = new WhatsAppNotifier("https://api.whatsapp.example/send", whatsAppClient, waValidator);
        svc.register(wa);

        //Wire Email
        EmailClient emailClient = new FakeEmailClient();
        Validator mailsValidator = new EmailValidator();
        Notifier mailNotifier = new EmailNotifier("https://api.whatsapp.example/send", emailClient, mailsValidator);
        svc.register(mailNotifier);
        return svc;
    }
}
