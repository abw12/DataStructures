package LeetCode_String;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s){
        String[] words=s.split(" ");
        int len=words.length;
        String lastWord=words[len-1];

        return lastWord.length();
    }

    public static void main(String[] args) {
        LengthOfLastWord obj =new LengthOfLastWord();
        String input = "   fly me   to   the moon  ";
        System.out.println("Length of the last word is: "+ obj.lengthOfLastWord(input));
    }
}
