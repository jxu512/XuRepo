package demos.companies.jpm;

import java.util.*;

public class SummaryTripletsToZero {
    
    public static void main(String[] args) {
        int[] nums = { -1,-2,-3,0,2,3,5 };
    	SummaryTripletsToZero summaryTripletsToZero = new SummaryTripletsToZero();
    	List<List<Integer>> triplets = summaryTripletsToZero.getTriplets(nums);
    	System.out.println(triplets);
    }

    public List<List<Integer>> getTriplets(int[] nums) {
        List<List<Integer>> listThreeOrLess = new ArrayList<>();
        // Empty set is the seed, if not wanted, exclude at end
        listThreeOrLess.add(new ArrayList<Integer>());
        // Loop through each element
        for(int i=0;i<nums.length;i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> r : listThreeOrLess) {
                List<Integer> copy = new ArrayList<>(r);
                copy.add(nums[i]);
                if(copy.size()<=3) temp.add(copy);
            }
            listThreeOrLess.addAll(temp);
        }
        // Keep only triplets whose sum is zero
        List<List<Integer>> triplets = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        listThreeOrLess.forEach(triplet->{
            if(triplet.size()==3
                    && triplet.get(0) + triplet.get(1) + triplet.get(2) == 0) {
                Collections.sort(triplet);
                set.add(triplet);
            }
        } );
        triplets.addAll(set);
        return triplets;
    }
}