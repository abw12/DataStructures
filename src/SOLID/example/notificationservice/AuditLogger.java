package SOLID.example.notificationservice;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public interface AuditLogger {
    void log(AuditEvent event);
}

record AuditEvent(Instant ts,Channel channel,String to, boolean success, String details){}

class FileAuditLogger implements AuditLogger{
    private final String path;
    public FileAuditLogger(String path) { this.path = path; }

    @Override
    public void log(AuditEvent e) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write("%s | %s | %s | %s | %s%n".formatted(
                    e.ts(), e.channel(), e.to(), e.success() ? "OK" : "FAIL", e.details()
            ));
        } catch (IOException io) {
            // In real code: use SLF4J logger here
            System.err.println("Audit write failed: " + io.getMessage());
        }
    }
}