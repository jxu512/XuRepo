/*
https://leetcode.com/problems/move-zeroes/description/
 */

package demos.leetcode;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                nums[pointer++] = nums[i];
            }
        }
        for (int i=pointer;i<nums.length;i++) {
            nums[i] = 0;
        }
    }
}
