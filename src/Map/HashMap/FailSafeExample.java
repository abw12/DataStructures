package Map.HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafeExample {
    public static void main(String[] args) {

        Map<Integer,String> map =new HashMap<>();
        map.put(1,"Abhishek");
        map.put(2,"Sarang");
        map.put(3,"Vedant");
//        map.put(null,"idea");
//        map.put(4,"shweta");
//        map.put(null,"abhijit");
        //Java Map.HashMap is a non-synchronized collection class.
        // If we need to perform thread-safe operations on it then we must need to synchronize it explicitly.
        // The synchronizedMap() method of java.util.Collections class is used to synchronize it.
        // It returns a synchronized (thread-safe) map backed by the specified map.
            Map<Integer,String> synchMap= Collections.synchronizedMap(map); //these type of map are thread-safe It locks the whole map,
        // it just a synchronised wrapper over the hashmap method

        Iterator it= synchMap.entrySet().iterator();
        while(it.hasNext()){
                System.out.println("Keys: " + it.next());

//            map.put(5,"raki"); //modifing the straucture of  map (by adding new key:value pair)while iterating over it give us ConcurrentModificationException
//            map.put(4,"raki"); //though it allow us to modify the value of existing key
            //therefore hashMap is an example of fail-fast
        }


        //It locks some portion of the map.
//       ConcuurentHashMap doesn’t allow inserting null as a key or value
        ConcurrentHashMap chash = new ConcurrentHashMap<>();
        //concurrenthashmap allow us to modify map while traversing
        // since it operate on the copy of the map and does not change structure of the original map
        //hence it's an example of fail-safe iterator
        chash.putAll(map); //this will throw an nullpointerexception if we try to add a map with null key or values

        Iterator it2 = chash.values().iterator();
        while(it2.hasNext()){
            System.out.println("Values: " + it2.next() );

            chash.put(5,"Raki");
//            chash.put(null,null);
        }

    }
}
