package demos.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

public class TwoCitySchedule {
	public int twoCitySchedCost(int[][] costs) {
	       
	// Sort by cost difference
	Arrays.sort(costs, Comparator.comparingInt(cost->cost[0]-cost[1]));
	int len = costs.length;
	int total=0;
	for(int i=0;i<len/2;i++) 
		total += costs[i][0] + costs[i+len/2][1];
	
	return total;
	}

	public static void main(String[] args) {
		int[][] costs = 
			{
				{20, 200 },
				{30, 20},
				{50, 60},
				{300, 100}
			};
		
		TwoCitySchedule two =new TwoCitySchedule();
		System.out.format("Minimum cost: %d",two.twoCitySchedCost(costs));
	}
}
