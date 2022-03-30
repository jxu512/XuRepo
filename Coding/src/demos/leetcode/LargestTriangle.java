package demos.leetcode;

/*
 * arr[][] represents list of (x,y), find largest triangle by area
*/
public class LargestTriangle {

	public static void main(String[] args) {
		LargestTriangle tri =new LargestTriangle();
		int[][] arr = 
			{
				{9,5},
				{6,15},
				{2,12},
				{3,9},
				{7,18},
				{20,11},
				{8,15},
				{13,2}
			};
		double area = tri.largest_1(arr);
		System.out.println("Method 1:"+area);
	}

	
	private double largest_1(int[][] arr) {

		int n=arr.length;
		double area = 0;
		for(int i1=0;i1<=n-3;i1++) {
			for(int i2=i1+1;i2<=n-2;i2++) {
				for(int i3=i2+1;i3<=n-1;i3++) {
					int x1=arr[i1][0], y1=arr[i1][1];
					int x2=arr[i2][0], y2=arr[i2][1];
					int x3=arr[i3][0], y3=arr[i3][1];
					double a=0.5*Math.abs((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1));
					area=a>area?a:area;
				}
			}
		}
		return area;
	}
	
}
