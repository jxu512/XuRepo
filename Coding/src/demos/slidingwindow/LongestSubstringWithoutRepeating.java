/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/
package demos.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;
        if (s.length()==1) return 1;

        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while ( right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = max > set.size() ? max : set.size();
            } else {
                while (left < right) {
                    set.remove(s.charAt(left));
                    if (s.charAt(left++) == s.charAt(right)) break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
