/*
https://leetcode.com/problems/longest-common-prefix/description/
 */

package demos.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    // Method 1: faster
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) i++;
            else break;
        }
        return s1.substring(0, i);
    }

    // Method 2
    public String longestCommonPrefix1(String[] strs) {
        StringBuilder sb = new StringBuilder();
        boolean end = false;
        for (int i = 0;;i++) {
            char next = getCommon(strs, i);
            if (next == '\0') break;
            sb.append(next);
        }
        return sb.toString();
    }

    private char getCommon(String[] strs, int i) {
        if (strs[0].length()<i+1) return '\0';
        for (int j=1;j<strs.length;j++) {
            if (strs[j].length()<i+1) return '\0';
            if (strs[j].charAt(i) != strs[0].charAt(i)) return '\0';
        }
        return strs[0].charAt(i);
    }

}
