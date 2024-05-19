/*
https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
*/

package demos.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximunNumberOfEvents {
    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b)->b[1]-a[1]);
        int end=events[0][1];
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        int start = events[0][0];
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int last = 0;
        for (int d = start;d<=end;d++) {
            // Push events starting on day d to pq
            while (last < events.length && events[last][0] == d) pq.offer(events[last++][1]);

            // Remove events ended
            while (!pq.isEmpty() && pq.peek()<d) pq.poll();
            // Pick event ending soonest to attend for day d
            if (!pq.isEmpty()) {
                pq.poll();
                total ++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] events = { {1,2},{2,3},{3,4} };
        System.out.println(maxEvents(events));
    }
}
