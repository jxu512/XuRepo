package demos.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort2 {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1) return nums;

        int pivot = nums[new Random().nextInt(nums.length)];
        List<Integer> left = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int n : nums) {
            if (n < pivot) left.add(n);
            else if (n == pivot) middle.add(n);
            else right.add(n);
        }

        int leftarr[] = sortArray(left.stream().mapToInt(Integer::intValue).toArray());
        int rightarr[] = sortArray(right.stream().mapToInt(Integer::intValue).toArray());

        int result[] = new int[nums.length];
        int i = 0;
        for (int n : leftarr) result[i++] = n;
        for (int n : middle) result[i++] = n;
        for (int n : rightarr) result[i++] = n;
        return result;
    }
}
