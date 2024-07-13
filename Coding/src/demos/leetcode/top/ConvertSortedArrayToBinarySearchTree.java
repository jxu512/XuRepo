/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
*/
package demos.leetcode.top;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getNode(nums, 0, nums.length-1);
    }
    private TreeNode getNode(int[] nums, int s, int e) {
        if (s > e) return null;
        if (s == e) return new TreeNode(nums[s]);
        int m = (s + e) / 2;
        TreeNode node = new TreeNode(nums[m], getNode(nums, s, m-1), getNode(nums, m+1, e));

        return node;
    }
}
