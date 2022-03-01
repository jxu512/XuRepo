package demos.hackerrank;

/*
Arrai tower[n], where tower[i] represent number of blocks at position i.
Ex:
[3 1 5]
Position 1 can hold 2 units of water
Return: water units can be help by tower.

*/

public class WaterTower {

	public int calcWater(int[] tower) {
		
		// Fine highest tower to the left for all positions
		int[] left = new int[tower.length];
		left[0] = tower[0];
		for(int i=1;i<tower.length;i++) {
			left[i]=Math.max(left[i-1], tower[i]);
		}
		// Fine highest tower to the right for all positions
		int[] right = new int[tower.length];
		right[tower.length-1] = tower[tower.length-1];
		for(int i=tower.length-2;i>=0;i--) {
			right[i]=Math.max(right[i+1], tower[i]);
		}
		// Calc water for each position
		int sum=0;
		for(int i=0;i<tower.length;i++) {
			sum+=Math.min(left[i], right[i])-tower[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		int[] tower = { 3, 5, 6, 2, 8 };
		WaterTower water = new WaterTower();
		System.out.format("Water units: %d", water.calcWater(tower));
	}
	
}
