/*
https://leetcode.com/problems/plus-one/description/
*/
package demos.leetcode.top;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // The operations stops first digit less than 9
        int n = digits.length;
        for (int i=n-1;i>=0;i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        // If it comes here, the number is 9...99, and result is 10...00
        int[] newDigits = new int[n+1];
        newDigits[0]=1;
        return newDigits;
    }
}
