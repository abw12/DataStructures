package LeetCode.Strings;

//Medium level question

/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

        The algorithm for myAtoi(string s) is as follows:

        Read in and ignore any leading whitespace.
        Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either.
        This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
        Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
        Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
        Change the sign as necessary (from step 2).
        If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range.
        Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
        Return the integer as the final result.
        Note:

        Only the space character ' ' is considered a whitespace character.
        Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
*/

public class StringToInteger {

    public static void main(String[] args) {
        String s = "21474836460";
        System.out.println(stringToInt(s));
        System.out.println(atoi(s));
    }


    //similar approach only change is using the built-in trim and isDigit method of java which is more readable and quick to solve ij interview
    //time and space complexity also remain the same
    private static Integer atoi(String s){
        int result=0;
        String trimS=s.trim(); //remove the leading and trailing white spaces
        int len = trimS.length();
        boolean negativeFlag=false;

        if(len == 0) return 0; //if after trimming the string is empty return 0 immediately
        int i=0;
        //check the symbol
        if(trimS.charAt(i) == '-'){
            negativeFlag=true;
            i++;
        }else if(trimS.charAt(i) == '+'){
            i++;
        }

        // loop over for valid integer characters
        while(i < len && Character.isDigit(trimS.charAt(i))){

            //front digit
            int digit = trimS.charAt(i) - '0'; //ASCII value of 0 = 48 so example integer 5=53 and 0= 48 => 53-48= 5

            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > 7) ){
                return negativeFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE; //return min/max value if the number is overflowed over the 32 bit signed range
            }
            result = result * 10 + digit;
            i++;
        }
        return negativeFlag ? -result : result;
    }

    //time complexity is O(n)
    //space complexity is O(1)
    private static int stringToInt(String s){
        final int len = s.length();

        if(len ==0){
            return 0;
        }

        int index =0;

        //ignoreing the and moving the index ahead if space ' ' is found
        while(index < len && s.charAt(index) == ' '){
            ++index;
        }


        boolean isNegative=false;

        //to handle sign case
        if(index < len){
            if(s.charAt(index) == '-'){
                isNegative=true;
                ++index;
            }else if(s.charAt(index) == '+'){
                ++index;
            }
        }

        int result = 0 ;

        while(index < len && isDigit(s.charAt(index))){
            /* str.charAt(index) - '0' is to convert the char digit into int digit eg: '5' - '0' --> 5
      or else it will store the ASCII value of 5 i.e. 53,
      so we do 53(ASCII of 5) - 48(ASCII of 0(zero)) to get 5 as int*/
            int digit = s.charAt(index) - '0';

            // to avoid integer overflow

            if(result > (java.lang.Integer.MAX_VALUE /10) || (result == (java.lang.Integer.MAX_VALUE/10) && digit > 7)){
                return isNegative ? java.lang.Integer.MIN_VALUE : java.lang.Integer.MAX_VALUE;
            }

            result = (result * 10) + digit;

            ++index;
        }

        return  isNegative ? -result : result;
    }

    private static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
}


//Explanation

    /*means in JAVA? You will be able to figure out this statement easily for C++ code too.

        result > (Integer.MAX_VALUE / 10) means:
        Suppose,
        result = 214748365(9 digits)
        Integer.MAX_VALUE = 2147483647(10 digits) and Integer.MAX_VALUE / 10 = 214748364(9 digits)
        Here, it is clearly evident that result > Integer.MAX_VALUE / 10( i.e. 214748365 > 214748364) and if we try to add even 0(zero)
        in result 214748365(9 digits), the number will become 2147483650(10 digits) which is obviously greater than 2147483647(Integer.MAX_VALUE
         which is of 10 digits). So even before adding 0(zero) or any other digit, we return the Integer.MAX_VALUE or Integer.MIN_VALUE,
         according to the sign case, in order to avoid integer overflow.
     */

     /*   And, result == (Integer.MAX_VALUE / 10) && digit > 7 means:
        Suppose,
        result = 214748364(9 digits), and
        Integer.MAX_VALUE / 10 = 214748364(9 digits)
        Now,if the result is equal to the Integer.MAX_VALUE / 10 (214748364 == 214748364) and the digit is greater than 7 i.e. digit > 7
         and if we try to add 8(assume the digit greater than 7 to be 8) to the result, then the number will become 2147483648(10 digits)
        , which will result in integer overflow. So, even before adding the digit which is greater than 7,
         we return the Integer.MAX_VALUE or Integer.MIN_VALUE, according to the sign case, to avoid integer overflow.*/