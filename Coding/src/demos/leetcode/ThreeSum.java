/*
https://leetcode.com/problems/3sum/description/
 */

package demos.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                if (nums[left]+nums[right] < -nums[i]) {
                    left++;
                    continue;
                } else if (nums[left]+nums[right] > -nums[i]) {
                    right--;
                    continue;
                }
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                tmp.add(nums[left++]);
                tmp.add(nums[right--]);
                list.add(tmp);
                while (left<right && nums[left-1]==nums[left]) left++;
                while (left<right && nums[right]==nums[right+1]) right--;
            }
        }
        return list;
    }

}
