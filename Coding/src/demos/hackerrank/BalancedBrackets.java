package demos.hackerrank;

import java.util.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        // Write your code here
        if (s.length()%2==1) return "NO";

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (isLeft(s.charAt(i))) stack.push(s.charAt(i));
            else {
                if (stack.isEmpty()) return "NO";
                if (!isMatched(stack.pop(), s.charAt(i))) return "NO";
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
    private static boolean isLeft(char c) {
        return c=='(' || c=='[' || c=='{';
    }
    private static boolean isMatched(char c1, char c2) {
        return (c1=='(' && c2==')')
                || (c1=='[' && c2==']')
                || (c1=='{' && c2=='}');
    }

    public static void main(String[] args) {

        System.out.println(isBalanced("{}[(([]))]"));
    }
}

