/*
https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */

package demos.priorityqueue;

import java.util.PriorityQueue;

public class KthLargestNumberInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for (int i : nums) pq.offer(i);
        for (int i=0;i<k-1;i++) pq.poll();
        return pq.poll();
    }
}
