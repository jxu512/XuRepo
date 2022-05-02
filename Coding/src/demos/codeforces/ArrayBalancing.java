/*
https://codeforces.com/problemset/problem/1661/A

Sample input:
3 3 10 10
10 10 3 3

1 2 3 4 5
6 7 8 9 10

72 101 108 108 111 44
10 87 111 114 108 100

Output:
0
8
218
*/
package demos.codeforces;

public class ArrayBalancing {
	public static void main(String[] args) {
		
		//int[] a = {3, 3, 10, 10};
		//int[] b = {10, 10, 3, 3};
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {6, 7, 8, 9, 10};
		
		//int[] a = {72, 101, 108, 108, 111, 44};
		//int[] b = {10, 87, 111, 114, 108, 100};
		
		System.out.println(balancing(a,b));
	}
	
	private static int balancing(int[] a, int[] b) {
		
		int sum;
		int len=a.length;
		
		sum=0;
		for(int i=1;i<len;i++) {
			int s1 = Math.abs(a[i]-a[i-1]) + Math.abs(b[i]-b[i-1]) ;
			int s2 = Math.abs(b[i]-a[i-1]) + Math.abs(a[i]-b[i-1]) ;
			if(s1<s2) {
				sum += s1;
			}
			else {
				sum += s2;
				int temp = a[i];
				a[i]=b[i];
				b[i]=temp;				
			}
		}
		
		return sum;
	}
}
