/*
https://leetcode.com/problems/string-compression/description/
 */

package demos.leetcode;

public class StringCompression {
    public int compress(char[] chars) {
        int p = 0;
        int i = 0;
        while (i < chars.length) {
            int count = findSeq(chars, i);
            chars[p++] = chars[i];
            if (count > 1) {
                String numStr = ""+count;
                for (int j=0;j<numStr.length();j++) chars[p++] = numStr.charAt(j);
            }
            i += count;
        }
        return p;
    }

    private int findSeq(char[] chars, int idx) {
        int count = 1;
        for (int i=idx + 1;i<chars.length;i++) {
            if (chars[i] == chars[idx]) {
                count ++;
            } else break;
        }

        return count;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','a','b','b','a','a','a','a','a','a','a','a','a','a','a','a'};
        StringCompression stringCompression = new StringCompression();
        System.out.println(new String(chars));
        int len = stringCompression.compress(chars);
        for (int i=0;i<len;i++) System.out.print(chars[i]);
        System.out.println();
    }
}
