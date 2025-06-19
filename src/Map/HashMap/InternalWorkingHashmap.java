package Map.HashMap;

import java.util.HashMap;

public class InternalWorkingHashmap {

    public static void main(String[] args) {
        //a hashmap contain an array of node and each node  represents a class having following objects
//        int hash
//        K key
//        V value
//        Node next

        //by default bucket capacity is 16 (starts from index 0 -15)
        HashMap map = new HashMap();

//        the below put method will perform below steps
//        1)Calculate hash code of Key {“vishal”}. It will be generated as 118.
//        2)Calculate index by using index method it will be 6.
//        3)Create a node object as :
        map.put(new Key("vishal"),25);

       /* Calculate hashCode of Key {“sachin”}.
       It will be generated as 115.
        Calculate index by using index method it will be 3.
        Create a node object as :*/
//        {
//            int hash = 115
//            Key key = {"sachin"}
//            Integer value = 30
//            Node next = null
//        }
        map.put(new Key("sachin"),30);

//        In Case of collision: Now, putting another pair that is,
//        Calculate hash code of Key {“vaibhav”}. It will be generated as 118.
//        Calculate index by using index method it will be 6.
//        Create a node object as :
//        {
//            int hash = 118
//            Key key = {"vaibhav"}
//            Integer value = 40
//            Node next = null
//        }
/*        Place this object at index 6 if no other object is presented there.
        In this case, a node object is found at index 6 – this is a case of collision.
        In that case, check via the hashCode() and equals() method if both the keys are the same.
        If keys are the same, replace the value with the current value.
        Otherwise, connect this node object to the previous node object via linked list and both are stored at index 6.
        Now Map.HashMap becomes :*/
        map.put(new Key("vaibhav"), 40);

        /*Calculate hash code of Key {“sachin”}. It will be generated as 115.
        Calculate index by using index method it will be 3.
        Go to index 3 of the array and compare the first element’s key with the given key. If both are equals then return the value, otherwise, check for the next element if it exists.
        In our case, it is found as the first element and the returned value is 30.*/
        map.get(new Key("sachin"));


        /*Calculate hash code of Key {“vaibhav”}. It will be generated as 118.
        Calculate index by using index method it will be 6.
        Go to index 6 of the array and compare the first element’s key with the given key. If both are equals then return the value, otherwise, check for the next element if it exists.
        In our case, it is not found as the first element and the next node object is not null.
        If the next node is null then return null.
        If the next of node is not null traverse to the second element and repeat process 3 until the key is not found or next is not null.
        Time complexity is almost constant for the put and the get method until rehashing is not done.
        In case of collision, i.e. index of two or more nodes are the same, nodes are joined by a link list i.e. the second node is referenced by the first node and the third by the second, and so on.
        If the key given already exist in Map.HashMap, the value is replaced with the new value.
        hash code of the null key is 0.
        When getting an object with its key, the linked list is traversed until the key matches or null is found on the next field*/
        map.get(new Key("vaibhav"));

    }
}
