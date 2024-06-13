/*
https://leetcode.com/problems/degree-of-an-array/description/
 */

package demos.leetcode;

import java.util.*;

public class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        SortedMap<Integer, Integer> count = new TreeMap<>();
        SortedMap<Integer, Integer> first = new TreeMap<>();
        int degree = 0;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            first.putIfAbsent(nums[i], i);
            if (count.get(nums[i]) > degree) {
                shortest = i - first.get(nums[i]) + 1;
                degree = count.get(nums[i]);
            } else if (count.get(nums[i]) == degree) {
                shortest = shortest <= i - first.get(nums[i]) + 1 ? shortest : i - first.get(nums[i]) + 1;
            }
        }

        return shortest;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,2,3,1};//,4,2};
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        System.out.println(degreeOfArray.findShortestSubArray(nums));
    }
}
