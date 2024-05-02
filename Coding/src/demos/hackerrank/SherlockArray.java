/*
Input: int[] arr
Output: YES: if there a position i to which the sum from elements left to i equals to the sum to the right of i
Note: left to 0 and right to length-1 is 0
 */

package demos.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SherlockArray {

    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        if (arr.size()==1) return "YES";

        int right = arr.stream().mapToInt(Integer::new).sum() - arr.get(0);
        int left = 0;
        if (left == right) return "YES";
        for (int i=1;i<arr.size();i++) {
            left += arr.get(i-1);
            right -= arr.get(i);
            if (left == right) return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(2);

        System.out.println(balancedSums(list));
    }
}
