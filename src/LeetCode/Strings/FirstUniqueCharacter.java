package LeetCode.Strings;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String input="loveleetcode";

        int[] freq =new int[256]; //we are using 256 length of array bcoz to support the other characters as well
//      counting the fequency of each character by using ascii table value of those characters and store them in an array
        for(int i=0 ; i < input.length();i++){
            freq[input.charAt(i) - 'a']++; // this will store 1 at index position charAt - 'a' eg: l - a = 108 - 97 = 11 index (as per ASCII table)
        }

        for(int i=0; i < input.length();i++){
            if(freq[input.charAt(i) - 'a'] == 1) {
                System.out.println("Index of first Unique Character: " + i);
                break;
            }
        }

    }
}
