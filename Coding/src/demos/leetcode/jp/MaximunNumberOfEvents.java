/*
https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
*/

package demos.leetcode.jp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximunNumberOfEvents {
    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort events increasing by start time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0, i = 0, n = events.length;
        for (int d = 1; d <= n; d++) {
            // Add new events that start on day `d`
            while (i < n && events[i][0] == d) {
                minHeap.add(events[i][1]);
                i++;
            }
            // Remove events that are already closed
            while (!minHeap.isEmpty() && minHeap.peek() < d) {
                minHeap.poll();
            }
            // Use day `d` to attend to the event that closes earlier
            if (!minHeap.isEmpty()) {
                ans++;
                minHeap.poll();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = { {1,3},{1,3},{1,3},{3,4} };
        System.out.println(maxEvents(events));
    }
}
