/*
https://leetcode.com/problems/first-unique-character-in-a-string/description/
*/
package demos.leetcode.top;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInString {

    // Use HashMap for counnts
    public int firstUniqChar1(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i=0;i<arr.length;i++) {
            if (map.get(arr[i]) == 1) return i;
        }
        return -1;
    }

    // Use array for counts
    public int firstUniqChar2(String s) {
        char[] arr = s.toCharArray();
        int[] counts = new int[26];
        for (char c : arr) {
            counts[c-'a'] ++;
        }
        for (int i=0;i<arr.length;i++) {
            if (counts[arr[i]-'a'] == 1) return i;
        }
        return -1;
    }

}
