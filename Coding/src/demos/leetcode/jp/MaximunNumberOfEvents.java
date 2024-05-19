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

    // This is super fast
    public int maxEvents1(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length, ans = 0;
        int max = events[n-1][1];

        int[] arr1 = new int[max + 1];
        int[] arr2 = new int[max + 1];
        for (int i = 1; i <= max; i++) arr1[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = events[i][0]; j <= events[i][1]; j++) {
                if (arr2[j] != 0)
                    j = arr2[j];
                else if (arr1[j] != -1) {
                    ans++;
                    arr2[events[i][0]] = arr1[j];
                    arr1[j] = -1;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = { {1,3},{1,3},{1,3},{3,4} };
        System.out.println(maxEvents(events));
    }
}
