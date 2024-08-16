package demos.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ArraySum {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArraySum arraySum = new ArraySum();
        arraySum.test();
    }

    private void test() throws ExecutionException, InterruptedException {
        int[] nums = init();
        System.out.println(Arrays.stream(nums).sum());
        ForkJoinPool pool = ForkJoinPool.commonPool();
        //int sum = pool.invoke(new SumTask(nums));         // invoke, wait and get result
        SumTask task = new SumTask(nums);
        pool.execute(task);                 // Async execute, need to get result later
        int sum = task.get();
        System.out.println(sum);
    }

    private int[] init() {
        int len = 50_000;
        int[] arr = new int[len];

        for (int i=0;i<len;i++) {
            arr[i] = (int)(Math.random()*len);
        }

        return arr;
    }

}

class SumTask extends RecursiveTask<Integer> {

    int[] nums;
    public SumTask(int[] nums) {
        this.nums = nums;
    }
    @Override
    protected Integer compute() {
        if (nums.length<20) {
            return Arrays.stream(nums).sum();
        } else {
            int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length/2);
            int[] nums2 = Arrays.copyOfRange(nums, nums.length/2,nums.length);
            SumTask task1 = new SumTask(nums1);
            SumTask task2 = new SumTask(nums2);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}