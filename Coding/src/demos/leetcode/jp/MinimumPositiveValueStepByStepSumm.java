/*
https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/
*/
package demos.leetcode.jp;

public class MinimumPositiveValueStepByStepSumm {
    public static int minStartValue(int[] nums) {

        int min = nums[0];
        for (int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            min = min < nums[i] ? min : nums[i];
        }
        if (min >= 0) return 1;
        else return 1 - min;
    }

    public static void main(String[] args) {
        int[] nums = {-3,2,-3,4,2};
        System.out.println(minStartValue(nums));
    }
}
