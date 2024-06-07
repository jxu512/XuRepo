package demos.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumToK {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i=1;i<sums.length;i++) sums[i] += sums[i-1] + nums[i];
        for (int i=0;i<nums.length;i++) {
            for (int j=i;j<nums.length;j++) {
                if (sums[j]==k) total++;
                sums[j] -= nums[i];
            }
        }
        return total;
    }

    /*
    sum has cumulative sum up to current position, say p1. We want to find subarray starting p1 backwards with subarray sum of k.
    The map has all cumulative sum of the array. If there exists a key in the map with value sum1 with ending position p2 so that
    (sum - sum1) equals to k, we have got a subarray (p1+1, p2) whose subarray sum is k. That's why we use (sum-k) to
    lookup sum1 in the map.
     */
    public int subarraySum1(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);       // sum for empty subarray, needed to cover the case where the 1st number equals to k
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,-2,4,5};
        int k = 5;
        SubArraySumToK subArraySumToK = new SubArraySumToK();
        System.out.println(subArraySumToK.subarraySum1(nums, k));
    }
}
