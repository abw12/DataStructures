package BasicPrograms;

//How to remove Whitespaces from String
public class RemoveWhiteSpaceString {

    public static void main(String[] args) {
        String input ="My name Is Abhishek ";

        StringBuilder sb = new StringBuilder();
        for(char c : input.toCharArray()){
            if(!Character.isWhitespace(c)){
                sb.append(c);
            }
        }
        System.out.println(sb);

//        How to remove leading and trailing whitespaces from a string?

        String name = " hello world  ";

        name= name.strip(); //strip() introduced in java 11  remove trailing and leading whitespace just like trim() method
        // but strip() is more efficient since the trim() method identifies any character having codepoint value less than or equal to ‘U+0020’ as a whitespace character.
        System.out.println(name);
    }
}
