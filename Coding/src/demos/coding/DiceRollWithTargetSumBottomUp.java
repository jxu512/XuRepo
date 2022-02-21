package demos.coding;

/*
Success
Details 
Runtime: 13 ms, faster than 87.22% of Java online submissions for Number of Dice Rolls With Target Sum.
*/
public class DiceRollWithTargetSumBottomUp {
    
    public static void main(String[] args ) {
    	DiceRollWithTargetSumBottomUp roll = new DiceRollWithTargetSumBottomUp();
    	roll.numRollsToTarget(4, 6, 7);
    }

    public int numRollsToTarget(int n, int k, int target) {
        if (target > n*k) return 0;
        if(target<n) return 0;
        
        // Matrix
        // dp[0] not used, for easy index
        // dp[i] where i>0 is for number of i dice
        int[][] dp = new int[n+1][target+1];
        // 1 dice, target 1 to target
        for (int i = 1; i <= Math.min(k, target); i++) dp[1][i] = 1;

        // Build matrix for number of dice from 2 to n
        for (int i = 2; i <= n; i++){
        	/*
        	 For number of i dice, do target of j in i to target
        	 */
            for (int j = i; j <= target; j++){
            	// For each (i dice, j target), 
            	// sum of (i-1, j-w) where w in 1...k
	        	dp[i][j] = 0;
                for (int w = 1; w <= Math.min(k, j); w++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-w]) % 1000000007;
                }
            }
        }
        printDP(dp);
        return dp[n][target];
    }
    private void printDP(int[][] dp) {

    	for(int i=0;i<dp.length;i++) {
    		for(int k=0;k<dp[0].length;k++) System.out.print(dp[i][k]+" ");
    		System.out.println();
    	}
	}
}