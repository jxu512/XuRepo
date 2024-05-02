package demos.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {
    public static String isValid(String s) {
        // Write your code here
        if (s.length() == 1) return "YES";

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        int[] counts = map.values().stream().mapToInt(Integer::new).sorted().distinct().toArray();
        if (counts.length == 1
                || (counts.length == 2 && counts[0] + 1 == counts[1])
                || (counts.length == 3 && counts[0] == counts[1] && counts[0] == 1)){
            return "YES";
        } else{
            return "NO";
        }
    }

    public static void main(String[] args) {
        String s = "aabbcd";
        System.out.format("%s: %s", s, isValid(s));
    }
}
