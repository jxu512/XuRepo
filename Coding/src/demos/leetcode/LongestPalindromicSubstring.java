/*
https://leetcode.com/problems/longest-palindromic-substring/description/
 */

package demos.leetcode;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n];   // dp[i][j]: if substring (j, i + j -1) is palindrome
        Arrays.fill(dp[0], true);  // zero length palindrome
        Arrays.fill(dp[1], true);  // 1 letter palindrome
        for (int i=2; i<=n;i++) {
            for (int j=0;j<=n-i;j++) {
                dp[i][j] = dp[i-2][j+1] && (s.charAt(j) == s.charAt(j + i - 1));
            }
        }
        for (int i=n;i>1;i--) {
            for (int j=0;j<=n-i;j++) {
                if (dp[i][j]) return s.substring(j, j + i);
            }
        }
        return s.substring(0,1);
    }

    public static void main(String[] args) {
        String s = "abac";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome(s));
    }
}
