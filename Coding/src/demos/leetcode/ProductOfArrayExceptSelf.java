/*
https://leetcode.com/problems/product-of-array-except-self/description/
 */

package demos.leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        for (int i=1;i<nums.length;i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }
        int suffix = 1;
        for (int i=nums.length-2;i>=0;i--) {
            suffix *= nums[i+1];
            ans[i] *= suffix;
        }
        return ans;
    }
}
