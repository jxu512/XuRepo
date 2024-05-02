package demos.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/*
Success
Details 
Runtime: 13 ms, faster than 87.22% of Java online submissions for Number of Dice Rolls With Target Sum. 

 */
public class DiceRollWithTargetSumBacktracking {
    
	long loops = 0;
    public int numRollsToTarget(int n, int k, int target) {

    	List<Integer> temp = new ArrayList<Integer>();
    	int num = rollDice(1, n, k, target,target, temp);

        return num;
    }

	private int rollDice(int i, int dices, int faces, int target, int origTarget, List<Integer> temp) {

		if(target<dices || target>dices*faces) 
			return 0;
        if(dices==0) {
	        int total = temp.stream().mapToInt(Integer::intValue).sum();
	        //System.out.println(temp);
	        if(total==origTarget) return 1;
	        	else return 0;
        }
		/*
		 each dice can take 1..k
		 */
        int sum = 0;
		for(int j=1;j<=Math.min(faces, target);j++) {
			temp.add(j);
			loops++;
			sum = (sum+rollDice(i+1, dices-1, faces, target-j,origTarget, temp))%1000000007;
			temp.remove(temp.size()-1);
		}
		
        return sum;
    }
    
    public static void main(String[] args ) {
    	DiceRollWithTargetSumBacktracking roll = new DiceRollWithTargetSumBacktracking();
    	int num=roll.numRollsToTarget(5, 6, 20);
    	System.out.format("Number:%d, loops:%d",num,roll.loops);
    	
    }

}