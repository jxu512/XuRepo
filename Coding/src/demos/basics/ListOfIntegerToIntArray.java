package demos.basics;

import java.util.ArrayList;
import java.util.List;

public class ListOfIntegerToIntArray {
    public static void main(String[] args) {

        int[] nums;
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        //nums = list1.toArray();   // Compile error: can't convert Object[] to int[]
        //nums = list1.toArray(new Integer[0]);   // Same error as above
        nums = list1.stream().mapToInt(Integer::intValue).toArray();    // Method 1
        for (int i = 0;i<list1.size();i++) nums[i] = list1.get(i);      // Method 2

        List<int[]> list2 = new ArrayList<>();
        list2.add(new int[] {1,2});
        list2.add(new int[] {3,4});
        list2.add(new int[] {5,6});
        int[][] numList = list2.toArray(new int[0][0]);     // This works because int[] is class not primitive
    }

}
