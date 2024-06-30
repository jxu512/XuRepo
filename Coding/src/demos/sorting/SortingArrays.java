package demos.sorting;

import java.util.Arrays;

public class SortingArrays {

    public static void main(String[] args) {

        long t1, t2;

        t1 = System.currentTimeMillis();
        int[] nums = init();
        Arrays.parallelSort(nums);
        t2 = System.currentTimeMillis();
        System.out.println("Arrays.parallelSort took: " + (t2-t1));

        t1 = System.currentTimeMillis();
        nums = init();
        Arrays.sort(nums);
        t2 = System.currentTimeMillis();
        System.out.println("Arrays.Sort took: " + (t2-t1));

        t1 = System.currentTimeMillis();
        nums = init();
        nums = Arrays.stream(nums).parallel().sorted().toArray();
        t2 = System.currentTimeMillis();
        System.out.println("Paralleltream took: " + (t2-t1));

        t1 = System.currentTimeMillis();
        nums = init();
        nums = Arrays.stream(nums).sorted().toArray();
        t2 = System.currentTimeMillis();
        System.out.println("Stream took: " + (t2-t1));
    }

    private static int[] init() {
        int len = 20_000_000;
        int[] arr = new int[len];

        for (int i=0;i<len;i++) {
            arr[i] = (int)(Math.random()*len);
        }

        return arr;
    }
}
