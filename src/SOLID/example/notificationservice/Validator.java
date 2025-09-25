package SOLID.example.notificationservice;



public interface Validator{
    void validate(Notification n);
}

class WhatsAppValidator implements Validator{

    @Override
    public void validate(Notification n) {
        if (n.to() == null || !n.to().startsWith("+")) {
            throw new IllegalArgumentException("Invalid WhatsApp recipient: " + n.to());
        }
    }
}

class EmailValidator implements Validator {
    @Override
    public void validate(Notification n) {
        if (n.to() == null || !n.to().contains("@")) {
            throw new IllegalArgumentException("Invalid email: " + n.to());
        }
    }
}
