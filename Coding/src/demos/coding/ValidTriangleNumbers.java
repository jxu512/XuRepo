/*
	inout: int[] nums
	Return: number of 3 number forming triangles
 */
package demos.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidTriangleNumbers {

	public int numOfValidTriangles(int[] nums) {
		List<Integer> tmp = new ArrayList<>();
		List<List<Integer>> list = new ArrayList<>();
		findThree(nums, 0,tmp, list);
		int count = 0;
		for (List<Integer> three : list) {
			if (isValidTriangle(three.get(0), three.get(1), three.get(2))) {
				count++;
			}
		}
		return count;
	}

	private void findThree(int[] nums, int i, List<Integer> tmp, List<List<Integer>> list) {

		if(i==nums.length) {
			if ( tmp.size() == 3) {
				list.add(new ArrayList<>(tmp));
			}
			return;
		}

		// Pick the element
		tmp.add(nums[i]);
		findThree(nums, i+1, tmp, list);
		// Don't pick the element
		tmp.remove(tmp.size()-1);
		findThree(nums, i+1, tmp, list);
	}

	public int bruteforce(int[] nums) {
		int count = 0;
		int totalThress = 0;
		for (int i=0;i<nums.length-2;i++) {
			for (int j=i+1;j<nums.length-1;j++) {
				for (int k=j+1;k<nums.length;k++) {
					if (isValidTriangle(nums[i],nums[j],nums[k])) {
						count++;
					}
					totalThress ++;
				}
			}
		}
		return count;
	}
	private boolean isValidTriangle(int a, int b, int c) {

		if ( (a+b) > c && (a+c) > b && (b+c) > a ) {
			System.out.printf("(%d,%d,%d) ", a, b, c);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		ValidTriangleNumbers validTriangleNumbers = new ValidTriangleNumbers();
		int[] nums = {3,4,5,7,6,20,15,12,16};
		System.out.println(validTriangleNumbers.bruteforce(nums));
		System.out.println(validTriangleNumbers.numOfValidTriangles(nums));
	}
}
