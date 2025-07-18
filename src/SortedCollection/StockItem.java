package SortedCollection;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }
    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if(price > 0.0){
            this.price = price;
        }
    }

    public void adjustStock(int quantity){
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >= 0){
            this.quantityStock=newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        String objName=((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode(){
        return this.name.hashCode() + 12;  // any arbitrary number we give to get consistent hashcode
    }

    @Override
    public int compareTo(StockItem o){
        if(this == o){
            return 0;
        }
        if(o!=null){
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return name + " : Price - " + price + " : Quantity - " + quantityStock ;
    }
}
