package SOLID.example.notificationservice;

public interface TemplateEngine {
    String render(Notification n);
}

class SimpleTemplateEngine implements TemplateEngine{
    @Override
    public String render(Notification n) {
        String header = "[HEADER]";
        String footer = "[FOOTER]";
        return header + "\n" + (n.subject() == null ? "" : n.subject()) + "\n" + n.body() + "\n" + footer;
    }
}
