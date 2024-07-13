/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
*/
package demos.leetcode.top;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        if (needle.length()>haystack.length()) return -1;
        for (int i=0;i<haystack.length() - needle.length() + 1;i++) {
            if (match(haystack, i, needle)) return i;
        }
        return -1;
    }
    private boolean match(String haystack, int start, String needle) {
        for (int i=0;i<needle.length();i++) {
            if (needle.charAt(i) != haystack.charAt(i+start)) return false;
        }
        return true;
    }
}
