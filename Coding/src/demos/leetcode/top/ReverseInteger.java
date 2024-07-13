/*
https://leetcode.com/problems/reverse-integer/
*/
package demos.leetcode.top;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = x < 0 ? true : false;
        x = isNegative ? -x : x;
        int r = 0;
        while (x > 0) {
            try {
                r = Math.multiplyExact(r, 10);
                r += x % 10;
                x /= 10;
            } catch (ArithmeticException e) {
                r = 0;
                break;
            }
        }

        return isNegative ? -r : r;
    }

}
