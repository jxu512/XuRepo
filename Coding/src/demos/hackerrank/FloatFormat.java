package demos.hackerrank;

import java.util.Arrays;
import java.util.List;

public class FloatFormat {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int zeros =0, postitve=0, negative=0;
        for (int i : arr) {
            if (i==0) zeros++;
            else if (i>0) postitve++;
            else negative++;
        }

        System.out.format("%.6f\n", (float)postitve/arr.size());
        System.out.format("%.6f\n", (float)negative/arr.size());
        System.out.format("%.6f\n", (float)zeros/arr.size());

    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,1,0,2,-2, -1);
        plusMinus(arr);
    }
}
