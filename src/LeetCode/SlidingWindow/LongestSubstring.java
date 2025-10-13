package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubstring {

    public static void checkSubstring(String s){
//        Set<Character> substring = new HashSet<>();
//        List<Character> substring = new ArrayList<>();
//        int longest=0;
//        for(char c : s.toCharArray()){
//            if(!substring.contains(c)){
//                substring.add(c);
//            }else {
//                if(longest < substring.size()) longest = substring.size();
//
//                substring.removeAll(substring);
//
//                substring.add(c);
//            }
//        }
//        if(longest < substring.size() ) longest=substring.size();
//
//        System.out.println("Longest Substring: " +longest);

     /*   the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values,
                and keep two pointers which define the max substring.
        move the right pointer to scan through the string , and meanwhile update the hashmap.
        If the character is already in the hashmap, then move the left pointer to the right of the same character last found.
                Note that the two pointers can only move forward.*/

//        s= "pwwkew"
        Map<Character/*letters*/,Integer/*index*/> map = new HashMap<>();
        int max=0;
        //here r act like a right pointer and l act like a left pointer
        for(int r=0,l=0; r < s.length(); r++ ){
            if(map.containsKey(s.charAt(r))){   //store the key as single character in a given string and its value is the position of character
                l=Math.max(l,map.get(s.charAt(r))+1); //shift left pointer only when you find the repeated character
            }
            //overwriting the repeated character index in the map if found or else add it for the first time
            map.put(s.charAt(r),r);
            max=Math.max(max,r-l+1); //this gives  us the max substring length since r is traversing on entire string and l
            // will be at the position where we found our last repeated character
            //and we do +1 in both scenario sicne the character index in the string starts from the 0th base indices
        }
        System.out.println("Longest Substring: " +max);

        ///this solution is just giving the length of longest substring it will not return the actual substring itself
    }


    public static void main(String[] args) {
        String s="pwwekwmsab"; // o/p: 3
        checkSubstring(s);
    }


}
