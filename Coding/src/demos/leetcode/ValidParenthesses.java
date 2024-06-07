/*
https://leetcode.com/problems/valid-parentheses/submissions/1278703977/
 */

package demos.leetcode;

import java.util.Stack;

public class ValidParenthesses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (isLeft(c)) stack.push(c);
            else {
                if (stack.isEmpty() || !match(stack.pop(), c)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeft(char c) {
        return c=='(' || c=='[' || c=='{';
    }
    private boolean isRight(char c) {
        return c==')' || c==']' || c=='}';
    }
    private boolean match(char c1, char c2) {
        return (c1=='(' && c2==')') || (c1=='[' && c2==']') || (c1=='{' && c2=='}');
    }
}
