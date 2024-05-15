/*

 Going to Nth stair with 1 step or 2 step at one time, find out possible ways to get to Nth stair.
 For ex :If we want to reach at 4th Step: No of ways would be : 1+1+1+1, 2+2, 1+1+2, 2+1+1, 1,2,1

 */

package demos.dynamicprogramming;

import java.util.Arrays;

public class NthStair {

    public static void main(String[] args) {
        int n = 60;
        System.out.printf("Get to %dth with dp: %d", n, nstair(n));
        System.out.printf("\nGet to %dth with recursive: %d", n, nstair(n));
    }

    private static int nstair(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }

    private static int stairRecursive(int n) {
        if (n == 0) return 1;
        if( n== 1) return 1;
        if (n == 2) return 2;

        return stairRecursive(n-1) + stairRecursive(n-2) + stairRecursive(n-3);
    }
}
