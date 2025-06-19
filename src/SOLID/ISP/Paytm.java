package SOLID.ISP;
//Since Paytm does not support the cashBack feature we have created a separate interface for it
// so that we don't have to provide implementation for unused methods in paytm Class
//this follows the Interface segregation principle
public class Paytm implements UPIPayments{
    @Override
    public void sendMoney(long amount) {

    }

    @Override
    public void getScratchCard() {

    }
}
