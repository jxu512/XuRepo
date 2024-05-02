package demos.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrequencyArray {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        Integer[] s = new Integer[100];
        Arrays.fill(s, 0);
        for (int i=0;i<arr.size();i++) {
            s[arr.get(i)] ++;
        }
        // Autoboxing does not work for array, so s must be Integer[] instead of int[]
        return Arrays.asList(s);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.add(9);
        arr.add(88);

        countingSort(arr);
    }
}

