package SortedCollection;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private  final Map<StockItem,Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list=new TreeMap<>();
    }

    public int addToBasket(StockItem item,int qunatity){
        if((item!=null) &&(qunatity>0)){
            int inBasket =list.getOrDefault(item,0);
            list.put(item,inBasket + qunatity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem,Integer> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
       String s= "\nShopping Basket "+ name + " Contains " + list.size() + " item\n";
       double totalCost=0.0;
       for(Map.Entry<StockItem,Integer> item: list.entrySet()){
           s= s + item.getKey() + " " + item.getValue() + " purchased\n";
           totalCost=item.getKey().getPrice() * item.getValue();
       }
       return s + "Total Cost "+ totalCost;
    }
}
