package LeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*  Input : /home/user/Documents/../Pictures
  Output: /home/user/Pictures
  Explanation:  double period ".." refers to the directory up a level (the parent directory).
  private */
public class SimplifyPath {

    private Stack<String> stack=new Stack<>();
    private String simplifyPath(String input){
        String[] splitArr = input.split("/");

        for(String comp : splitArr){
            if(comp.equals("") || comp.equals("."))
                continue;
            if (comp.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(comp);
            }
        }

        StringBuilder sb =new StringBuilder();
        while(!stack.isEmpty())
            sb.insert(0,"/"  + stack.pop());
        return sb.length() == 0 ? "/" : sb.toString();
    }

    // This demostrate that we can use different DataStructure as well to solve the
    // same problem using the same algorithm, basically deque is acting like stack only in this solution
    // this makes deque very flexible
    private static String usingDeque(String input){
        Deque<String> q = new ArrayDeque<>();
        String[] splits = input.split("/");
        for(String s: splits){
               if(s.equalsIgnoreCase("") || s.equalsIgnoreCase("."))
                   continue;
               if(s.equalsIgnoreCase("..")){
                   if(!q.isEmpty())
                       q.pollLast();
               }else{
                   q.offer(s);
               }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())
            sb.insert(0, "/" + q.pollLast());
        return sb.isEmpty() ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String input = "/home/user/Documents/../Pictures";
        String input2 = "/..//";
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath(input));
        System.out.println(usingDeque(input2));
    }
}
