package BasicPrograms;

/*Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

        Assume the environment does not allow you to store 64-bit integers (signed or unsigned).*/

public class ReverseIntegerLeetcode {
    public static void main(String[] args) {
        int num=-34567890;

        System.out.println(reverse(num));
        System.out.println(reverseUsingPreCheck(num));

    }

    private static int reverse(int num){
        int result=0;
        while( num !=0 ){
            int tail = num %10;
            int newResult = result * 10 + tail;
            if((newResult - tail) /10 != result){
                //it just simple doing opposite of line 14 and comparing the newResult value is same as old result value or not
//                If overflow exists, the new result will not equal previous one.
                //this condition is to make sure that last current result(sum of reverse digits)
                // within the range of 32-bit signed integer value (2^-31 to 2^31 -1) , and does not overflow it.
                return 0;
            }
            result=newResult;
            num = num/10;
        }
        return result;
    }

    //Full implementations using pre-check
    private static int reverseUsingPreCheck(int num){
        int rev=0;
        while(num !=0){
            int digit = num % 10;

            // positive signed pre-check before doing any arithmatic operations which could overflow the interger 2^31-1
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && digit > 7))
                    return 0;//Integer.MAX_VALUE = 2147483647(10 digits) last digit is 7 therefore one more comparison on the last digit (> 7 or < –8)
                                // finalises the decision.

            // negative overflow gaurd
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && digit < -8))
                    return 0;

            rev=rev * 10 + digit;
            num /= 10;
        }
        return rev;
    }
}
