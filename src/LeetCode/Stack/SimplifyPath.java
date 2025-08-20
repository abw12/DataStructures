package LeetCode.Stack;

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

    public static void main(String[] args) {
        String input = "/home/user/Documents/../Pictures";
        String input2 = "/..//";
        SimplifyPath sp = new SimplifyPath();
        System.out.println(sp.simplifyPath(input));
    }
}
