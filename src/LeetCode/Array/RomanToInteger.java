package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static Map<Character,Integer> romanSymbolMap = new HashMap<>();
    private static void fillRomanMap(){
        romanSymbolMap.put('I',1);
        romanSymbolMap.put('V',5);
        romanSymbolMap.put('X',10);
        romanSymbolMap.put('L',50);
        romanSymbolMap.put('C',100);
        romanSymbolMap.put('D',500);
        romanSymbolMap.put('M',1000);
    }

    private static Integer romanToInteger(String romanNum){
        fillRomanMap();
        int result = 0;
        Character prev_symbol = null;

        for(Character ch : romanNum.toCharArray()){
            if(prev_symbol != null){
                if(romanSymbolMap.get(prev_symbol) < romanSymbolMap.get(ch)){
                    result+=romanSymbolMap.get(ch) - romanSymbolMap.get(prev_symbol) *2; // subtracting twice the value since in previous iteration we have added the value first
                }else{
                    result+=romanSymbolMap.get(ch); // add the current symbol value to the total
                }
            }else{
                result+=romanSymbolMap.get(ch);
            }
            prev_symbol=ch; // keeping track of last encounter character
        }
        return result;
    }


    public static void main(String[] args) {
        String input="MCIVII";

        System.out.println(romanToInteger(input));
    }

}
