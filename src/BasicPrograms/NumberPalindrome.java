package BasicPrograms;

public class NumberPalindrome {

    public static void main(String[] args) {
        int ogNum = 22522;
        int rev = 0, rem, temp;
        temp = ogNum;
        while (temp > 0) {
            rem = temp % 10; // getting the remainder ie last digit from the given number
            rev = (rev * 10) + rem; // adding that last digit in front of rev
            temp = temp / 10; // removing the last digit from given input int
        }
        if (rev == ogNum) {
            System.out.println("Is palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

    }
}
