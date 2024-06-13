package demos.companies.ubs;

import java.util.HashSet;
import java.util.Set;

public class SumTwoNum {

    public boolean add(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i=1;i<nums.length;i++) {
            if (set.contains(k-nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = { 1,2,3,4,5,6};
        int k= 13;
        SumTwoNum sumTwoNum = new SumTwoNum();
        System.out.println(sumTwoNum.add(nums, k));
    }
}
