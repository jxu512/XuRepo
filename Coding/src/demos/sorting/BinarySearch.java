package demos.sorting;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        //int[] nums = {12};
        int[] nums = {1,3,5,7,9,11,13,15,17,19,21};
        int target = 13052;
        nums = init(target);
        int idx = search(nums, target);
        if (idx > -1) System.out.println(idx +":"+nums[idx]);
        else System.out.println(target +" not found in array.");
    }

    private static int[] init(int target) {
        int len = 10_000;
        int[] nums = new int[len];
        for (int i=0;i<nums.length;i++) {
            nums[i] = (int)(Math.random() * 1000000);
        }
        nums[(int)(Math.random()*100000)%len] = target;
        Arrays.parallelSort(nums);
        return nums;
    }

    private static int search(int[] nums, int target) {
        int l = 0, r=nums.length;
        int count = 0;
        while (l <= r) {
            System.out.format("loop %d: (%d,%d)\n", ++count, l, r);
            int m = (l + r)/2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) l = m+1;
            else r = m-1;
        }
        return -1;
    }
}
