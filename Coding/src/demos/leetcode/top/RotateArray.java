/*
https://leetcode.com/problems/rotate-array/description/
*/
package demos.leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {

    // Solution with list: slower
    public void rotate(int[] nums, int k) {
        if (k == 0) return;
        int n = nums.length;
        if (n==1) return;
        k = k % n;
        List<Integer> list = new ArrayList<>();
        for (int i = n - k;i<n;i++) list.add(nums[i]);
        for (int i = 0;i<n-k;i++) list.add(nums[i]);
        // Must assign values to array elements
        for (int i=0;i<n;i++) nums[i] = list.get(i);
        // Below won't work because nums is passed by reference and assignment won't be visible outside function
        // nums = list.stream().mapToInt(Integer::intValue).toArray();
    }

    // Solution with in-place swaps: faster
    public void rotate1(int[] arr, int k) {
        int size = arr.length;
        k = k % size;

        reverse(arr,0,size-1);
        reverse(arr,0,k-1);
        reverse(arr, k,size-1);

    }
    private static void reverse(int[] nums,int left,int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k=3;
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums,k);
    }
}
