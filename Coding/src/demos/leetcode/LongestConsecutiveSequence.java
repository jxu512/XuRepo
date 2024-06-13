/*
https://leetcode.com/problems/longest-consecutive-sequence/description/
 */

package demos.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxSeq = 0;
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int next = num + 1;
            int prev = num - 1;
            int currentSequence = 1;
            while (set.remove(prev--)) {
                currentSequence++;
            }
            while (set.remove(next++)) {
                currentSequence++;
            }
            if (currentSequence > maxSeq) {
                maxSeq = currentSequence;
            }
        }
        return maxSeq;
    }
}
