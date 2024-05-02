package demos.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static String pangrams(String s) {
        // Write your code here
        Set<Character> set = new HashSet<>();
        char[] arr = s.toLowerCase().toCharArray();
        if (s.length() < 26) {
            return "not pangram";
        }
        for (char c : arr) {
            if (c == ' ') {
                continue;
            }
            set.add(c);
            if (set.size() == 26) {
                return "pangram";
            }
        }
        return "not pangram";
    }

    public static void main(String[] args) {

        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(pangrams(s));
    }
}
