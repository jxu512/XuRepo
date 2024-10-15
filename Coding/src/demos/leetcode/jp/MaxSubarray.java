/*
https://leetcode.com/problems/maximum-subarray/description/
*/
package demos.leetcode.jp;

public class MaxSubarray {
    public static int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int max = currentMax;

        for (int i=1;i<nums.length;i++) {
            // If nums[i] > (currentMax+num[i], start new subarray
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(max, currentMax);
        }

        return max;
    }

    // Faster
    public static void main(String[] args) {
        int[] a = {-6,-2,-3,-4,-5};
        System.out.println(maxSubArray(a));
    }
}
