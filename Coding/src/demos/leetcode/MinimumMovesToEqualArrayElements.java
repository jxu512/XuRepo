/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

increase all elements except element i is same as decrease element i.
All it takes is to decrease each element to min
 */

package demos.leetcode;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int n = nums.length;
        if (n==1) return 0;
        int min = nums[0];
        for (int i=1;i<n;i++) min = min<=nums[i] ? min : nums[i];
        int total = 0;
        for (int i=0;i<n;i++) total += nums[i]-min;
        return total;
    }
}
