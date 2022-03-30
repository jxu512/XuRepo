package demos.dp;
/*
Success
Details 
Runtime: 13 ms, faster than 87.22% of Java online submissions for Number of Dice Rolls With Target Sum. 

 */
public class DiceRollWithTargetSumRecursion {
    
	long loops = 0;
    public int numRollsToTarget(int n, int k, int target) {
        int num = getNum(n, k, target);
        //System.out.println("Number:"+num);
        return num;
    }

	private int getNum(int n, int k, int target) {

        if (target > n*k) return 0;
        if(target<n) {
        	return 0;
        }
		if (n == 1){
			int res = 0;
            if (target > 0 && target <= k) res = 1;
            return res;
        }
        
        /* 
        For (n, target): 
        n-th dice can be i in 1...k, and for each selection i there are (n-1, target-i) cases,
        so, sum of all k of (n-1, target-i) gives (n, target)
        */
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += getNum(n-1, k, target-i);
            sum %= 1000000007;
            loops++;
        }
        return sum;
    }
    
    public static void main(String[] args ) {
    	DiceRollWithTargetSumRecursion roll = new DiceRollWithTargetSumRecursion();
    	roll.numRollsToTarget(3, 6, 15);
    }

}