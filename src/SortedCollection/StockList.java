package SortedCollection;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String,StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>(); //linkedHashMap is ordered
    }

    public int addStock(StockItem item){
        if(item!=null){
            //getOrdefualt check the list we have the given item name lese it return the default value
            StockItem inStock= list.getOrDefault(item.getName(),item);
            //if there are already stock in the item ,adjust the quantity
            if(inStock!=item ){
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(),item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item ,int quantity){
        StockItem inStock=list.getOrDefault(item,null);
        if((inStock!=null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get( key);
    }
    //UnmodifiableMap return the read-only access to the map which is specified
    public Map<String,StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }


    //not good way to write toString(0 as such in prod since it will print enitre list in log file
    @Override
    public String toString() {
        String s= "\nStock List\n";
        double totalCost=0.0;
        for(Map.Entry<String,StockItem> item: list.entrySet()){
            StockItem stockItem =item.getValue();
            double itemValue=stockItem.getPrice() * stockItem.quantityInStock();
            s=s + stockItem +". There are "+ stockItem.quantityInStock() + " in stock. Value of the items: ";
            s=s + String.format("%.2f",itemValue) + " \n";
            totalCost +=itemValue;
        }
        return s + "Total Stock Value  " + totalCost;
    }
}
