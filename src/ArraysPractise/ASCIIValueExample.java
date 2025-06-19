package ArraysPractise;

public class ASCIIValueExample {
    public static void main(String[] args) {
        String name= "abhishek";

        int[] arr = new int[256];
        char[] c = name.toCharArray();
        for(Character letter : c){
            int value= arr[letter]+=1; //arr['a'] will return the ascii value of a character which is 97 as per the table ,
            // since all array index values are initially kept as 0 , index position at 97 will return 0 & we add 1 to it as count.
            // so again if same character is received will do +1 to it
            System.out.println(letter + " " + (letter - 'a') + " " + value );
        }


    }
}
