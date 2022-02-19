package demos.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectArrays {

	public int[] intersect(int[] arr1, int[] arr2) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		// Sort arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		// Find intersect
		int len1=arr1.length;
		int len2 = arr2.length;
		int i=0;
		int k=0;
		while(true) {
			
			if(arr1[i]==arr2[k]) {
				list.add(arr1[i]);
				i++;
				k++;
			}
			else if(arr1[i]<arr2[k]) {
				i++;
			}
			else {
				k++;
			}
			
			// End condition
			if (i==len1 || k==len2) break;
		}
		
		return list.stream().mapToInt(num->num).toArray();
	}
	
	public static void main(String[] args) {
		
		IntersectArrays intersect = new IntersectArrays();
		int[] arr1 = { 1,3,4,5,8,9,11} ;
		int[] arr2 = { 2,3,5,7,9,10,11 };
		int[] result = intersect.intersect(arr1, arr2);
		
		for(int n:result) System.out.format("%d ",n);
	}
}
