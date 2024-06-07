/*
https://leetcode.com/problems/decode-string/description/
 */

package demos.leetcode;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> letters = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            } else if (c == '[') {
                numbers.push(n);
                n = 0;
                letters.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                int k = numbers.pop();
                StringBuilder temp = sb;
                sb = new StringBuilder(letters.pop());
                while (k-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String s = "3[a]2[bc2[d]]";
        System.out.println(decodeString.decodeString(s));
    }
}
