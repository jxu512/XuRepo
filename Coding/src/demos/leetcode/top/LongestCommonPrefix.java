/*
https://leetcode.com/problems/longest-common-prefix/description/
 */

package demos.leetcode.top;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        for (int i=strs[0].length();i>=0;i--) {
            String s = strs[0].substring(0,i);
            if (strs[strs.length-1].startsWith(s)) return s;
        }
        return "";
    }
}
