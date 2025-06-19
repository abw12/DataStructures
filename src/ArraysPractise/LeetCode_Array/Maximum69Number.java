package ArraysPractise.LeetCode_Array;

import java.util.ArrayList;
import java.util.List;

public class Maximum69Number {

    public static void main(String[] args) {
        //this is the brute force approach where converting the integer into arraylist and
        // then by finding the first 6 digit and converting it to 9 we will get our maximum number since only digit can be converted at a time
        //so we find the first occurrence of 6 from left to right(greedy approach)
        //6969 -> 9969 = maximum
        //9669 -> 9969 = maximum

        int input =99669;
        int answer=0;

        List<Integer> list = new ArrayList<>();
        while(input > 0){
            list.add(0,input%10);
            input/=10;
        }
        for(int i=0; i < list.size() ; i++){
            if(list.get(i) == 6){
                list.set(i,9);
                break;
            }
        }
        for(int i=0 ; i < list.size() ; i++){
            answer= list.get(i) + (answer * 10);
        }


        System.out.println("Maximum Number is : "+ answer);
    }
}

//better approach using a the placeValue of the digit and muliple by 3 * pow(10,placevalue) where place value is one's,Ten's,Hundred's,etc)
class Max69Num{
    public static void main(String[] args) {
             //3210  => power of 10 (as it is calculated in one's,Ten's,Hundred's,etc
        //eg = 9669

        //so if the power (placeValue of the first 6 from right to left side is 2)then will add 300 in the given input num which will give us the output
        //if the placeValue is 1 then we'll add 30 and so on

        int num = 9999;

        int placeValue=0;
        int placeValueSix=-1;

        int temp = num;
        while(temp > 0){
            int rem = temp%10;
            if(rem == 6){
                placeValueSix=placeValue;
            }
            placeValue++;
            temp=temp/10;
        }
        if(placeValueSix == -1){
            System.out.println("maximum number is: " + num);
        }else {
            int answer = (int) (num+3*Math.pow(10,placeValueSix));
            System.out.println("maximum number is : " + answer);
        }

    }
}
