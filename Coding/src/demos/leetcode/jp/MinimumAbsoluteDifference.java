/*
https://leetcode.com/problems/minimum-absolute-difference/description/
*/
package demos.leetcode.jp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i=1;i<arr.length;i++) {
            int d = arr[i] - arr[i-1];
            diff = diff < d ? diff : d;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i=1;i<arr.length;i++) {
            if (diff == arr[i] - arr[i-1]) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i-1]);
                l.add(arr[i]);
                res.add(l);
            }
        }
        return res;
    }
}
