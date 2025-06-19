package SOLID.DIP;

public class ShoppingMall {

    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public static void main(String[] args) {
        //in this way we are using abstraction and in future if we want to change to debit card then just have do changes in 1 line
        //below we'll just have to change to debit card
        BankCard card = new CreditCard(); //this is called runtime polymorphism (runtime it will decide what obj to create based on the reference)
        card.doTransaction(500);
    }
}
