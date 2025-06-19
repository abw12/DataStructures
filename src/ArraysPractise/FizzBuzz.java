package ArraysPractise;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<String>();
        for (int i=1 ; i <= n ; i++){

            boolean divideBy3= (i%3 == 0);
            boolean divideBy5 = (i%5 ==0);

            if(divideBy3 && divideBy5 ){
                list.add("FizzBuzz");
            } else if(divideBy3){
                list.add("Fizz");
            }else if(divideBy5){
                list.add("Buzz");
            }else{
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n=15;
        FizzBuzz obj=new FizzBuzz();
        System.out.println(obj.fizzBuzz(n));
    }
}
