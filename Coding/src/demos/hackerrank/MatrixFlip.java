package demos.hackerrank;

/*
	m[i][j] can be flipped with m[i][2*n-1-j], m[2*n-1-i][j], or m[2*n-1-i][2*n-1-j]
	pick the max of the four and summ all elements in nxn corner, or it can be any corner.
*/
public class MatrixFlip {
	// Flip 2nx2n matrix to get max sum for up left corner nxn
	public int flipUpLeftSum(int[][] m) {
		
		int sum=0;
		int n=m.length/2;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int max=Integer.MIN_VALUE;
				max = Math.max(max, m[i][j]);
				max = Math.max(max, m[i][2*n-1-j]);
				max = Math.max(max, m[2*n-1-i][j]);
				max = Math.max(max, m[2*n-1-i][2*n-1-j]);
				
				sum += max;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		int[][] m =
			{
				{112,42,83,119},
				{56,125,56,49},
				{15,78,101,43},
				{62,98,114,108}
			};
		
		MatrixFlip flip = new MatrixFlip();
		int sum=flip.flipUpLeftSum(m);
		System.out.format("Sum: %d", sum);
	}
}
