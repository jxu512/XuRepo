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
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (!map.containsKey(sorted)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(sorted, tmp);
            } else {
                map.get(sorted).add(str);
            }
        }

        ans.addAll(map.values());
        return ans;
    }
}
