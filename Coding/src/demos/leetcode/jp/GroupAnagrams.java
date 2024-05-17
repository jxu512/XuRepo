/*
leetcode.com/problems/group-anagrams/
*/
package demos.leetcode.jp;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            char[] seq = strs[i].toCharArray();
            Arrays.sort(seq);
            String sorted = new String(seq);
            if (map.get(sorted) == null) {
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(sorted, l);
            } else {
                map.get(sorted).add(strs[i]);
            }
        }

        map.values().forEach(v -> result.add(v));
        return result;
    }

}
