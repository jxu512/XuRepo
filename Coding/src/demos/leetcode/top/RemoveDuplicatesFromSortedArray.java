/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
*/
package demos.leetcode.top;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i] == nums[j-1]) continue;
            nums[j++] = nums[i];
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = { 1,1,2,2,2,4,5,6,6};
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        removeDuplicatesFromSortedArray.print(nums);
        removeDuplicatesFromSortedArray.removeDuplicates(nums);
        removeDuplicatesFromSortedArray.print(nums);
    }
    private void print(int[] nums) {
        for (int i : nums) System.out.print(i + ",");
        System.out.println();
    }
}
