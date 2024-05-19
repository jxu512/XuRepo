/*
https://leetcode.com/problems/maximum-subarray/description/
*/
package demos.leetcode.jp;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int max = currentMax;

        for (int i=1;i<nums.length;i++) {
            // If nums[i] > (currentMax+num[i], start new sequence
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            max = Math.max(max, currentMax);
        }

        return max;
    }

    // Faster
    private static int maxSubArray1(int[] nums) {
        int currSum = 0;
        int maxSum = nums[0];

        for(int i=0; i<nums.length; i++) {
            currSum += nums[i];

            maxSum = currSum > maxSum ? currSum : maxSum;
            if(currSum < 0) currSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {-6,-2,-3,-4,-5};
        System.out.println(maxSubArray1(a));
    }
}
