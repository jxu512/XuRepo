/*
https://leetcode.com/problems/reverse-string/description/
*/
package demos.leetcode.top;

public class ReverseString {
    public void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while (l < r) {
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
    }
}
