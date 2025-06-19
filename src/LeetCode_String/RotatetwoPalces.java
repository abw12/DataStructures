package LeetCode_String;

public class RotatetwoPalces {

    public static boolean rotateTwoPlace(String s1, String s2){

        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.length() == 2 ){
            return true;
        }
        String clock_rotate = "";
        String anticlock_rotate= "";
        int len= s2.length();
         anticlock_rotate = anticlock_rotate + s2.substring(2) + s2.substring(0,2); //shift left
        clock_rotate = clock_rotate + s2.substring(len-2,len) + s2.substring(0,len-2); //shift right

        return (anticlock_rotate.equals(s1) || clock_rotate.equals(s1) );


    }

    public static void main(String[] args) {
        String input="amazon";
        String after="azonam";

       System.out.println(rotateTwoPlace(input,after) ? "yes" : "no" );
    }
}
