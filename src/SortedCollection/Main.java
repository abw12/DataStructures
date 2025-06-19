package SortedCollection;

public class Main {
    private static StockList stocklist= new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("LIC",900.22,15);
        stocklist.addStock(temp);

        temp = new StockItem("ITC",260,20);
        stocklist.addStock(temp);

        temp = new StockItem("TATA POWER",220,30);
        stocklist.addStock(temp);

        temp = new StockItem("TCS",2300.25,10);
        stocklist.addStock(temp);

        temp = new StockItem("TECHM",1218.78,8);
        stocklist.addStock(temp);

        temp = new StockItem("WIPRO",110.78,19);
        stocklist.addStock(temp);

        System.out.println(stocklist);

        Basket basket = new Basket("abhishek");
        sellItem(basket,"WIPRO",5);
        System.out.println(basket);

        sellItem(basket,"TECHM",3);
        sellItem(basket,"ITC",2);
        sellItem(basket,"LIC",7);
        System.out.println(basket);

        //if we try to add the item like below then we'll get the exception since hasp is read-only i.e unmodifiable
//        temp=new StockItem("LG",67.99,10);
//        stocklist.Items().put("LG",temp);

        //even thought we have unmodifiable map we still can modify the individual items in the collection but can't modify the collection
        stocklist.Items().get("ITC").adjustStock(10);
        stocklist.get("ITC").adjustStock(-10); //this way also it works as have implemented the get method in stocklist class


        System.out.println(stocklist);
    }
    public static int sellItem(Basket basket,String item,int quantity){
        //retrieve the item
        StockItem stockItem = stocklist.get(item);
        if(stockItem == null){
            System.out.println("You dont have " + item + " stock.so can't be sold");
            return 0;
        }
        if(stocklist.sellStock(item,quantity) != 0){
            basket.addToBasket(stockItem,quantity);
            return quantity;
        }else{
            System.out.println("You dont have enough " + item + " stock.Transaction failed");
        }
        return  0;
    }
}
