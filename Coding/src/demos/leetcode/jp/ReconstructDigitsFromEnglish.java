package demos.leetcode.jp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReconstructDigitsFromEnglish {

    public static void main(String[] args) {
        String s ="zeroonetwothreefourfivesixseveneightnine";
        System.out.println(new ReconstructDigitsFromEnglish().originalDigits(s));
    }
    public String originalDigits(String s) {
        Map<String, String> map = initMap();
        // Order numbers by uniqueness
        String[] numbers = { "zero","six","two","seven","five","eight","three","four","nine","one" };
        int[] a = new int[26];
        for (int i=0;i<s.length();i++) {
            a[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<10;i++) {
            while (peek(numbers[i], a)) {
                take(numbers[i], a);
                sb.append(map.get(numbers[i]));
            }
        }
        char[] seq = sb.toString().toCharArray();
        Arrays.sort(seq);
        return new String(seq);
    }
    private boolean peek(String num, int[] a) {
        int[] b = Arrays.copyOf(a, a.length);
        for (int i=0;i<num.length();i++) {
            if (--b[num.charAt(i)-'a']<0) return false;
        }
        return true;
    }
    private void take(String num, int[] a) {
        for (int i=0;i<num.length();i++) {
            --a[num.charAt(i)-'a'];
        }
    }

    private Map<String, String> initMap() {
        Map<String, String> map = new HashMap<String,String>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        return map;
    }

}
