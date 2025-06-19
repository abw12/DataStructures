package SOLID.OCP;

//if we already have implementation to send otp via email and sms and there is new requirement
// to send it via whatsapp then we just create one interface like below and implement it in different classes
//therefore here we allow to extend /implement from this notificationService interface instead of doing changes in
//the NotificationService class in the SRP package. Therefore we follow OCP principle
public interface NotificationService {

    void sendOTP();

    void sendTransactionReport();

}
