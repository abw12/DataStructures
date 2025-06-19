package SOLID.SRP;

public class NotificationService {

    public void sendOTP(String medium){

        if(medium.equals("email")){
            //send otp via email
        }else if (medium.equals("SMS")){
            //send otp via SMS
        }
    }

    public void sendTranscriptViaEmail(){
        //send transcript of transactions
    }
}
