package demos.leetcode.top;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i=0;i<nums.length;i++) {
            if (set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        return set.iterator().next();
    }

    // faster
    public int singleNumber2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int ans = nums[0];
        for (int i=1;i<nums.length;i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
