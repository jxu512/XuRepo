package demos.companies.ubs;

public class SimpleSort {

    public String sort(String s) {

        char[] arr = s.toCharArray();
        int minIdx = 0;
        for (int i=0;i<arr.length-1;i++) {
            char min = arr[i];
            minIdx = i;
            for (int j=i+1;j<arr.length;j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            char tmp = arr[i];
            arr[i] = min;
            arr[minIdx] = tmp;
        }

        String ans = new String(arr);
        return ans;
    }

    public static void main(String[] args) {

        String s = "13216";
        SimpleSort simpleSort = new SimpleSort();
        System.out.println("Before: " + s);
        System.out.println("After: " + simpleSort.sort(s));

    }
}
