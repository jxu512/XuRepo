package demos.sorting;

public class QuickSort1 {

    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        new QuickSort1().quickSort(arr, 0, arr.length-1);
    }
    private void quickSort(int[] nums, int start, int end) {
        if (start>=end) {
            return;
        }
        int left = start, right = end;
        int p = nums[start + (end-start)/2];
        while (left < right) {
            while (nums[left]<p) left++;
            while (nums[right]>p) right--;

            if (left < right) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
            if (left <= right) {
                left++;
                right--;
            }
        }
        quickSort (nums, start, right);
        quickSort (nums, left, end);
    }

}
