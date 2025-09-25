package SOLID.example;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Intentionally bad design: violates SRP, OCP, LSP, ISP, DIP
 */
public class ViolatesSOLID {

    // Hardcoded provider configs (DIP violation)
    public String smtpHost = "smtp.example.com";
    public String smtpUser = "no-reply@example.com";
    public String smtpPass = "secret";
    public String twilioKey = "TWILIO-KEY";
    public String whatsappApiUrl = "https://api.whatsapp.example/send";

    // Mutable global-ish state
    private static Map<String, String> templates = new HashMap<>();

    // Super-generic "send" (OCP violation via if/else per channel)
    public boolean send(String channel, String to, String subject, String message, byte[] attachment) {
        // Load templates from DB every time (SRP + performance smell)
        loadTemplatesFromDb();

        String finalBody = applyTemplate(subject, message);

        // Inline validation logic (SRP violation)
        if ("email".equalsIgnoreCase(channel)) {
            if (!to.contains("@")) {
                System.out.println("Invalid email id: " + to);
                return false;
            }
            return sendEmail(to, subject, finalBody, attachment);
        } else if ("sms".equalsIgnoreCase(channel)) {
            if (!to.matches("\\d{10}")) {
                System.out.println("Invalid phone for SMS: " + to);
                return false;
            }
            return sendSms(to, finalBody);
        } else if ("whatsapp".equalsIgnoreCase(channel)) {
            if (!to.startsWith("+")) {
                System.out.println("Invalid phone for WhatsApp: " + to);
                return false;
            }
            return sendWhatsapp(to, finalBody);
        } else {
            // Adding a new channel requires modifying this method (OCP violation)
            System.out.println("Unknown channel: " + channel);
            return false;
        }
    }

    // Template concerns mixed in (SRP violation)
    private String applyTemplate(String subject, String body) {
        String header = templates.getOrDefault("header", "[HEADER]");
        String footer = templates.getOrDefault("footer", "[FOOTER]");
        return header + "\n" + subject + "\n" + body + "\n" + footer;
    }

    // Direct DB access (SRP + DIP violations)
    private void loadTemplatesFromDb() {
        if (!templates.isEmpty()) return; // pretend cache

        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:demo");
             Statement st = conn.createStatement()) {

            st.execute("CREATE TABLE IF NOT EXISTS templates (k VARCHAR, v VARCHAR)");
            st.execute("MERGE INTO templates KEY(k) VALUES ('header','=== Company ==='),('footer','--- Thank you ---')");

            try (ResultSet rs = st.executeQuery("SELECT k, v FROM templates")) {
                while (rs.next()) {
                    templates.put(rs.getString("k"), rs.getString("v"));
                }
            }
        } catch (SQLException e) {
            System.out.println("DB error: " + e.getMessage()); // swallowed (error handling smell)
        }
    }

    // Inline provider logic + fake retries + side-effects (SRP, DIP)
    private boolean sendEmail(String to, String subject, String body, byte[] attachment) {
        // Pretend to use JavaMail directly here
        System.out.printf("Sending EMAIL via SMTP(%s) to=%s subject=%s\n", smtpHost, to, subject);
        boolean success = simulateNetworkCall();

        audit("EMAIL", to, success, subject);
        return success;
    }

    private boolean sendSms(String to, String body) {
        // Pretend to call Twilio directly
        System.out.printf("Sending SMS via Twilio key=%s to=%s\n", twilioKey, to);
        boolean success = simulateNetworkCall();

        audit("SMS", to, success, body);
        return success;
    }

    private boolean sendWhatsapp(String to, String body) {
        // Pretend to call WhatsApp HTTP API
        System.out.printf("Sending WhatsApp via %s to=%s\n", whatsappApiUrl, to);
        boolean success = simulateNetworkCall();

        audit("WHATSAPP", to, success, body);
        return success;
    }

    // File I/O mixed in (SRP violation)
    private void audit(String channel, String to, boolean success, String payload) {
        try (FileWriter fw = new FileWriter("audit.log", true)) {
            fw.write(Instant.now() + " | " + channel + " | " + to + " | " + (success ? "OK" : "FAIL") + " | " + payload + "\n");
        } catch (IOException e) {
            // swallow
            System.out.println("Audit write failed: " + e.getMessage());
        }
    }

    // Pretend network instability
    private boolean simulateNetworkCall() {
        return Math.random() > 0.2;
    }

    // Mixed responsibilities continued
    public void setSmtpHost(String smtpHost) { this.smtpHost = smtpHost; }
    public void setTwilioKey(String twilioKey) { this.twilioKey = twilioKey; }
    public void setWhatsappApiUrl(String whatsappApiUrl) { this.whatsappApiUrl = whatsappApiUrl; }
}
