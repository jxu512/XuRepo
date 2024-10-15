/*
https://leetcode.com/problems/happy-number/description/
*/
package demos.leetcode.jp;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.format("\n" + n + " is happy: " + isHappy(n));
    }
    static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int k;
        while (true) {
            k = 0;
            if ( set.contains(n)) return false;
            set.add(n);
            while (n > 0) {
                k += (n%10) * (n%10);
                n /= 10;
            }
            n = k;
            if (n==1) return true;
            System.out.print(n + ",");
        }
    }
}
