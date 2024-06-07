/*
https://leetcode.com/problems/sliding-window-maximum/description/
 */

package demos.leetcode;

import java.util.*;

public class SlidingWindowMaximum {

    // PriorityQueue
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        List<Integer> list = new ArrayList<>();

        if (nums.length == 1) return nums;

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        list.add(queue.peek());

        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i - k]);
            queue.offer(nums[i]);
            list.add(queue.poll());
            //System.out.println(list);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // Dynamic programming
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows

        // left & right
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            if (i % k == 0) left[i] = nums[i];
            else left[i] = Math.max(left[i - 1], nums[i]);
            
            int j = n - i - 1;
            if (j % k == (k - 1)) right[j] = nums[j];
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        // dp
        for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
            result[i] = Math.max(right[i], left[j]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1,3,-1,-3,5,3,6,7 };

        ///*
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in).useDelimiter(",");
        while (scanner.hasNextInt()) list.add(scanner.nextInt());
        nums = list.stream().mapToInt(Integer::intValue).toArray();
        //*/

        long t1 = System.currentTimeMillis();
        int[] ans = maxSlidingWindow1(nums, 50000);
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken: " + (t2-t1));
    }
}
