/*
https://leetcode.com/problems/merge-intervals/description/
 */

package demos.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> list = new ArrayList<>();
        int len = intervals.length;
        int[] interval = intervals[0];
        for (int i=1;i<len;i++) {
            if (intervals[i][0] > interval[1]) {
                list.add(interval);
                interval = intervals[i];
            } else {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
        }
        list.add(interval);     // Last one
        return list.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
    }
}
