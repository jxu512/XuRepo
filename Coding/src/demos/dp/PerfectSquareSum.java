/*
https://leetcode.com/problems/perfect-squares/
Given integer n
Return minimum number of squares that sum to n
Ex:
3 for number 12: 12=4+4+4
2 for number 13: 13=4+9
*/

package demos.dp;

import java.util.Arrays;

public class PerfectSquareSum {
    public int numSquares(int n) {
    	// Dynamic programming
        int[] dp=new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0]=-1;
        int p=(int)Math.sqrt(n);
        // 1 for for perfect square numbers
        for(int i=1;i<=p;i++) dp[i*i]=1;
        // Calculate remainging
        for(int i=2;i<=n;i++) {
            if(dp[i]==1) continue;
            p=(int)Math.sqrt(i);
            // dp[i] is minimum of below
            for(int j=1;j<=p;j++){
                int jj=i-j*j;
                if(dp[i]>dp[jj]+1) dp[i]=dp[jj]+1;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}