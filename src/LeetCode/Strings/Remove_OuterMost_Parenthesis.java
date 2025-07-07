package LeetCode.Strings;

public class Remove_OuterMost_Parenthesis {

    public static void main(String[] args) {
        String s = "(()())((()))";
        System.out.println(removeOuterMostParenthesis(s));
        System.out.println("Another way: " + anotherWay(s));
    }

    private static String removeOuterMostParenthesis(String s) {
        StringBuilder result = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0)
                result.append(c);
            if (c == ')' && opened-- > 1)
                result.append(c);
        }
        return result.toString();

    }

    private static String anotherWay(String s) {

        StringBuilder sb = new StringBuilder();
        int open = 0, close = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }
            if (open == close) {
                sb.append(s, start + 1, i);
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
