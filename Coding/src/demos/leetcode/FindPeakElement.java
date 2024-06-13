/*
https://leetcode.com/problems/find-peak-element/description/

this question is tricly:
contition nums[i] != nums[i+1] and nums[0]>nums[-1] and nums[nums.length] together garantees there is at least one peak.
The binary search approach can catch one peak
 */

package demos.leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int n = nums.length;
        if (nums[0]>nums[1]) return 0;
        if (nums[n-1]>nums[n-2]) return n-1;

        int l = 1, r = n-2;
        while (l<=r) {
            int m = (l+r)/2;
            if (nums[m-1]<nums[m] && nums[m]>nums[m+1]) return m;
            else if (nums[m-1]>nums[m]) r = m-1;
            else if (nums[m+1]>nums[m]) l = m+1;
        }
        return -1;
    }
}
