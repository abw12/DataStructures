package SOLID.example.notificationservice;

import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class NotificationService {

    private final Map<Channel,Notifier> registry = new EnumMap<>(Channel.class);
    private final TemplateEngine templateEngine;
    private final AuditLogger auditLogger;

    public NotificationService(TemplateEngine templateEngine,AuditLogger auditLogger){
        this.templateEngine= Objects.requireNonNull(templateEngine);
        this.auditLogger=Objects.requireNonNull(auditLogger);
    }

    public void register(Notifier notifier){
        registry.put(notifier.channel(),notifier);
    }

    public SendResult send(Notification n){
        Notifier notifier = registry.get(n.channel());
        if(notifier == null){
            SendResult r = SendResult.fail("No notifier for channel: " + n.channel());
            auditLogger.log(new AuditEvent(Instant.now(), n.channel(), n.to(), false, r.details()));
            return r;
        }

        //pipeline: validate & render inside notifier/template
        Notification rendered = new Notification(n.channel(),n.to(),n.subject(),templateEngine.render(n),n.attachment());
        SendResult result = notifier.send(rendered);

        auditLogger.log(new AuditEvent(Instant.now(),n.channel(),n.to(),result.success(),result.details()));
        return result;
    }


}
