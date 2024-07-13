/*
https://leetcode.com/problems/valid-palindrome/description/
*/
package demos.leetcode.top;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (!validChar(arr[l])) {
                l++;
                continue;
            }
            if (!validChar(arr[r])) {
                r--;
                continue;
            }
            if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r])) return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean validChar(char c) {
        return
                (c >= 'a' && c <= 'z')
                        || (c >= 'A' && c <= 'Z')
                        || (c >= '0' && c <= '9');
    }
}
