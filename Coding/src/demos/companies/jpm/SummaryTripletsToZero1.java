package demos.companies.jpm;

import java.util.*;

public class SummaryTripletsToZero1 {
    
    public static void main(String[] args) {
        int[] nums = { -1,-2,-3,0,2,3,5 };
    	SummaryTripletsToZero1 summaryTripletsToZero = new SummaryTripletsToZero1();
    	List<List<Integer>> triplets = summaryTripletsToZero.getTriplets(nums);
    	System.out.println(triplets);
    }

    public List<List<Integer>> getTriplets(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Map<Integer, SortedSet<Integer>> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (map.get(nums[i]) == null) {
                SortedSet<Integer> temp = new TreeSet<>();
                temp.add(i);
                map.put(nums[i], temp);
            } else {
                map.get(nums[i]).add(i);
            }
        }

        Set<List<Integer>> tripletSet = new HashSet<>();
        for (int i=0;i<nums.length-2;i++) {
            for (int j=i+1;j<nums.length-1;j++) {
                int twoSum = nums[i] + nums[j];
                SortedSet<Integer> set = map.get(-twoSum);
                if (set != null) {
                    int k = set.last();
                    if ( k > i && k > j) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        tripletSet.add(list);
                    }
                }
            }
        }

        triplets.addAll(tripletSet);
        return triplets;
    }
}