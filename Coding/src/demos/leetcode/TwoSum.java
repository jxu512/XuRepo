/*
https://leetcode.com/problems/two-sum/description/
 */

package demos.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            if (!map.containsKey(target-nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[] { map.get(target-nums[i]), i};
            }
        }

        return new int[] {-1,-1};
    }
}
