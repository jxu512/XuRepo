package demos.dp;

import java.text.NumberFormat;
import java.util.Locale;

/*
Success
Details 
Runtime: 13 ms, faster than 87.22% of Java online submissions for Number of Dice Rolls With Target Sum.
*/
public class DiceRollWithTargetSumCompare {
    
    public static void main(String[] args ) {
    	
    	int n=Integer.parseInt(args[0]);
    	int k=Integer.parseInt(args[1]);
    	int target=Integer.parseInt(args[2]);
    	
    	System.out.format("Input: %d, %d, %d\n", n,k,target);
    	DiceRollWithTargetSumBacktracking roll4 = new DiceRollWithTargetSumBacktracking();
    	DiceRollWithTargetSumRecursion roll1 = new DiceRollWithTargetSumRecursion();
    	DiceRollWithTargetSumTopDown roll2 = new DiceRollWithTargetSumTopDown();
    	DiceRollWithTargetSumBottomUp roll3 = new DiceRollWithTargetSumBottomUp();
    	
    	long t1,t2;
    	int num=0;
    	String loops=null;
    	t1 = System.currentTimeMillis();
    	//num = roll4.numRollsToTarget(n, k, target);
    	t2 = System.currentTimeMillis();
    	loops = NumberFormat.getNumberInstance(Locale.US).format(roll4.loops);
    	System.out.format("Number: %d, Time: %d ms, loops: %s\n",num, (t2-t1)/2, loops);
    	
    	t1 = System.currentTimeMillis();
    	//num = roll1.numRollsToTarget(n, k, target);
    	t2 = System.currentTimeMillis();
    	loops = NumberFormat.getNumberInstance(Locale.US).format(roll1.loops);
    	System.out.format("Number: %d, Time: %d ms, loops: %s\n",num, (t2-t1)/2, loops);
    	
    	t1 = System.currentTimeMillis();
    	num = roll2.numRollsToTarget(n, k, target);
    	t2 = System.currentTimeMillis();
    	loops = NumberFormat.getNumberInstance(Locale.US).format(roll2.loops);
    	System.out.format("Number: %d, Time: %d ms, loops: %s\n",num, (t2-t1)/2, loops);
    	
    	t1 = System.currentTimeMillis();
    	num = roll3.numRollsToTarget(n, k, target);
    	t2 = System.currentTimeMillis();
    	loops = NumberFormat.getNumberInstance(Locale.US).format(roll3.loops);
    	System.out.format("Number: %d, Time: %d ms, loops: %s\n",num, (t2-t1)/2, loops);

}


}