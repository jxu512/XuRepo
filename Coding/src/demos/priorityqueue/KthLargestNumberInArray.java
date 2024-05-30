/*
https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */

package demos.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestNumberInArray {

    public static void main(String[] args) {
        int[] a = {3,6,-1,-6,9,8};
        a = init();
        int k = 10;
        int value;

        long t1, t2;
        t1 = System.currentTimeMillis();
        value = findKthLargest(a,k);
        t2 = System.currentTimeMillis();
        System.out.println("Max PriorityQueue took " + (t2-t1) + "ms," + value);

        t1 = System.currentTimeMillis();
        value = findKthLargest4(a,k);
        t2 = System.currentTimeMillis();
        System.out.println("Min PriorityQueue took " + (t2-t1) + "ms," + value);

        t1 = System.currentTimeMillis();
        value = findKthLargest1(a,k);
        t2 = System.currentTimeMillis();
        System.out.println("Sorting took " + (t2-t1) + "ms," + value);

        t1 = System.currentTimeMillis();
        value = findKthLargest2(a,k);
        t2 = System.currentTimeMillis();
        System.out.println("Scan k times took " + (t2-t1) + "ms," + value);

        t1 = System.currentTimeMillis();
        value = findKthLargest3(a,k);
        t2 = System.currentTimeMillis();
        System.out.println("Stream took " + (t2-t1) + "ms," + value);

    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b)->b-a);
        for (int i : nums) maxQ.offer(i);
        for (int i=0;i<k-1;i++) maxQ.poll();
        return maxQ.poll();
    }
    public static int findKthLargest4(int[] nums, int k) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        for (int i : nums) {
            if (minQ.size() >= k  && i < minQ.peek()) continue;
            else if (minQ.size() >= k) minQ.poll();
            minQ.offer(i);
        }
        return minQ.poll();
    }

    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static int findKthLargest2(int[] nums, int k) {
        int[] r = new int[k];
        for (int i=0;i<k;i++) {
            r[i] = -1;
            for (int j=0;j<nums.length;j++) {
                if (nums[j] > r[i] && (i==0 || nums[j]<r[i])) r[i] = nums[j];
            }
        }
        return nums[nums.length-k];
    }

    public static int findKthLargest3(int[] nums, int k) {

        return Arrays.stream(nums)//.parallel()
                .sorted()
                .skip(nums.length-k)
                .findFirst()
                .getAsInt();
    }

    private static int[] init() {
        int[] a = new int[8_000_000];
        for (int i=0;i<a.length;i++) a[i] = (int)(Math.random()*1_000_000);
        return a;
    }
}
