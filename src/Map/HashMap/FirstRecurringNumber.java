package Map.HashMap;

import java.util.*;

public class FirstRecurringNumber {
    //this is the optimal solution as we loop in linear time so o(n) complexity . HashSet does not store duplicate elements
    public Object findFirstRecurringNumber(Object[] arr){
        Set<Object> set=new HashSet<>();
      for(Object num: arr){
          if(set.contains(num)){
              return num;
          }else{
              set.add(num);
          }
      }
      return null;
    }

    public static void main(String[] args) {
        Object[] arr= {2,3,4,3,1,2,6,7,6};

        FirstRecurringNumber obj = new FirstRecurringNumber();
        System.out.println("First Recurring Number is: "+obj.findFirstRecurringNumber(arr));
    }
}
