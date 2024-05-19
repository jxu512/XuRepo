package demos.sorting;

public class MergeSort1 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};

        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1, temp);
    }

    private static void mergeSort(int[] nums, int start, int end, int[] t) {

        if (start >= end) return;
        int mid = start + (end-start)/2;
        mergeSort(nums,start, mid,t);
        mergeSort(nums,mid+1,end,t);
        merge(nums,start, mid,end,t);
    }
    private static void merge(int[] nums, int s, int m, int e, int[] t) {
        int p1=s, p2=m+1, p=s;
        while (p1<=m && p2<=e) {
            t[p++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1<=m) {
            t[p++] = nums[p1++];
        }
        while (p2<=e) {
            t[p++] = nums[p2++];
        }
        for (int i=s;i<=e;i++) nums[i] = t[i];
    }
}
