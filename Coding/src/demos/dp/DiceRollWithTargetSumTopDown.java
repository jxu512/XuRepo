package demos.dp;
/*
Success
Details 
Runtime: 13 ms, faster than 87.22% of Java online submissions for Number of Dice Rolls With Target Sum. 

 */
public class DiceRollWithTargetSumTopDown {
    long loops=0;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<dp.length;i++)
        	for(int j=0;j<dp[0].length;j++) dp[i][j] = -1;
        int num = getNum(n, k, target, dp);
        //printDP(dp);
        return num;
    }
    private void printDP(int[][] dp) {

    	for(int i=0;i<dp.length;i++) {
    		for(int k=0;k<dp[0].length;k++) System.out.print((dp[i][k])+" ");
    		System.out.println();
    	}
	}
	private int getNum(int n, int k, int target, int[][] dp) {

        if (target > n*k) return 0;
        if(target<n) {
        	if(target>=0) dp[n][target] = 0;
        	return 0;
        }
		if (n == 1){
			int res = 0;
            if (target > 0 && target <= k) res = 1;
            dp[n][target] = res;
            return res;
        }
        
        if (dp[n][target] != -1) return dp[n][target];
        /* 
        For (n, target): 
        n-th dice can be i in 1...k, and for each selection i there are (n-1, target-i) cases,
        so, sum of all k of (n-1, target-i) gives (n, target)
        */
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += getNum(n-1, k, target-i, dp);
            sum %= 1000000007;
            loops++;
        }
        dp[n][target] = sum;
        return sum;
    }
    
    public static void main(String[] args ) {
    	DiceRollWithTargetSumTopDown roll = new DiceRollWithTargetSumTopDown();
    	roll.numRollsToTarget(3, 6, 15);
    }

}