package ArraysPractise.LeetCode_Array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void convertToInteger(String input){
        Map<String,Integer> romanSymbolMap = new HashMap<>();
        romanSymbolMap.put("I",1);
        romanSymbolMap.put("V",5);
        romanSymbolMap.put("X",10);romanSymbolMap.put("L",50);romanSymbolMap.put("C",100);romanSymbolMap.put("D",500);
        romanSymbolMap.put("M",1000);

        String[] romanNum=input.split("");
        int sum=0;
        int len = romanNum.length-1;
        for(int i=0 ; i < len ; i++ ){
//            if(romanSymbolMap.get(romanNum[i]) > romanSymbolMap.get(romanNum[i+1])  ){
//                sum+= romanSymbolMap.get(romanNum[i]);
//            } else if (romanSymbolMap.get(romanNum[i]) < romanSymbolMap.get(romanNum[i+1]) ){
//                sum+= romanSymbolMap.get(romanNum[i+1]) - romanSymbolMap.get(romanNum[i]) ;
//                i++;
//            }else{
//                sum+= romanSymbolMap.get(romanNum[i]);
//                    if(i+1 == romanNum.length-1 && romanNum[i+1].equals("I") ) {
//                        sum += romanSymbolMap.get(romanNum[i + 1]);
//                    }
//            }
            if(romanSymbolMap.get(romanNum[i])  < romanSymbolMap.get(romanNum[i+1]) ){
                sum-= romanSymbolMap.get(romanNum[i]);
            }else{
                sum+= romanSymbolMap.get(romanNum[i]);
            }
        }
            sum+= romanSymbolMap.get(romanNum[len]);
        System.out.println("Roman Number " + input + " conversion to Interger is : " + sum);

    }


    public static void main(String[] args) {
        String input="MCIVII";

        convertToInteger(input);
    }

}
