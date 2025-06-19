package SOLID.SRP;

//instead of having all the functionality of the bank like loan,notification,printpassbook in one class
// we separate it by giving the responsibility of each functionality to different classes so that in future
// if there are any changes to be done it will become easy to do it
//hence this follows the single responsibility model

public class BankClass {

    public void withDrawCash(long amount){

    }

    public void depositCash(long amount){

    }
}
