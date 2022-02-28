package demos.coding;

/*
You are given an integer array coins representing coins of different denominations and an integer amount 
representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be 
made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
*/

import java.util.Arrays;

class CoinChange {
    	long loops=0;
    public int coinChange(int[] coins, int amount) {
        
        int[] matrix = new int[amount+1];
        Arrays.fill(matrix, amount+1);      // A number can't be reached
        matrix[0] = 0;                				// zero amount needs zero coin
        for(int coin:coins) if(coin<=amount) matrix[coin]=1;// Initialize, not required, recursion can take care of this as well
        int num = findChangesTopdown(coins, amount, amount, matrix);
        // Integer.MAX_VALUE/Integer.MAX_VALUE-1 indicates not possible, return -1 per required
        return num>=amount?-1:num;
    }
    
    private int findChangesTopdown(int[] coins, int amt, int amount, int[] matrix) {

        if(amt==0) return 0;
        if(matrix[amt]!=amount+1) return matrix[amt];
        
        for(int coin:coins) {
	            if(amt>=coin) {
		        	int found = findChangesTopdown(coins, amt-coin, amount, matrix);
		        	if( found!=amount )	matrix[amt] = Math.min(matrix[amt], found+1) ;
		        	loops ++;
	            }
	        // Set amount+2 indicating matrix[amt] has been processed, no reprocessing
            matrix[amt] = matrix[amt]==amount+1?amount+2:matrix[amt];
        }
        return matrix[amt];
    }
    public int coinChangeBottomup(int[] coins, int amount) {
        int max = amount + 1;
        int[] matrix = new int[max];
        Arrays.fill(matrix, max);
        matrix[0] = 0;			// Zero amount needs zero coin
        
        //iterate over from 1 to amount and each coin
        loops=0;
        for (int amt = 1; amt <= amount; amt++) {
            for (int coin:coins) {
                if(amt>=coin) {
                	matrix[amt] = Math.min(matrix[amt], matrix[amt-coin] + 1);
                loops++;
                }
            }
        }
        return matrix[amount] > amount ? -1 : matrix[amount];

    }
  
    public static void main(String[] args) {
    	
    	CoinChange change = new CoinChange();
    	int amount = 1226249;
    	int[] coins = {186,419,83,408,555};
    	
    	long t1, t2;
    	int num=0;
    	t1 = System.currentTimeMillis();
    	num = change.coinChange(coins, amount);
    	t2 = System.currentTimeMillis();
    	System.out.println(num+", loops:"+change.loops+", time:"+(t2-t1)/1000 );
    	t1 = System.currentTimeMillis();
    	num = change.coinChangeBottomup(coins, amount);
    	t2 = System.currentTimeMillis();
    	System.out.println(num+", loops:"+change.loops+", time:"+(t2-t1)/1000 );
    	
    }
}