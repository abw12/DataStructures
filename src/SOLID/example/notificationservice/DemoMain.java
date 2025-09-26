package SOLID.example.notificationservice;

public class DemoMain {
    public static void main(String[] args) {
        TemplateEngine template = new SimpleTemplateEngine();
        AuditLogger audit = new FileAuditLogger("audit.log");

        NotificationService svc = new NotificationService(template,audit);

        //Wire WhatsApp
        WhatsAppClient whatsAppClient = new FakeWhatsAppClient();
        Validator waValidator = new WhatsAppValidator();
        Notifier wa = new WhatsAppNotifier("https://api.whatsapp.example/send", whatsAppClient, waValidator);
        svc.register(wa);

        //Send one
        Notification n = new Notification(Channel.WHATSAPP,"+919999888877", "Greetings", "Hello from composition world!", null);
        SendResult r = svc.send(n);
        System.out.println("Result: " + r);
    }
}
