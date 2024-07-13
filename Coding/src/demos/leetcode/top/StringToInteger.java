/*
https://leetcode.com/problems/string-to-integer-atoi/
*/
package demos.leetcode.top;

public class StringToInteger {
    public int myAtoi(String s) {
        int sign = 1;
        int n = s.length();
        if (n == 0) return 0;
        char[] arr = s.toCharArray();

        int i = 0;
        while (i<n && arr[i] == ' ') i++;
        if (i>=n) return 0;

        if (arr[i] == '-') { sign = -1; i++; }
        else if (arr[i] == '+') { sign = 1; i++; }
        while (i<n && arr[i] == '0') i++;

        long sum = 0, sum1 = 0;
        while (i < n && Character.isDigit(arr[i])) {
            sum = sum * 10 + (arr[i] - '0');
            sum1 = sign * sum;
            if (sum1 < Integer.MIN_VALUE) {sum1 = Integer.MIN_VALUE;break;}
            if (sum1 > Integer.MAX_VALUE) {sum1 = Integer.MAX_VALUE;break;}
            i++;
        }

        return (int)sum1;
    }

}
