package demos.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SubArrayDivision {
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int count = 0;
        for (int i=0;i<s.size()-m+1;i++) {
            int sum = 0;
            for (int j=0;j<m;j++) {
                sum += s.get(i+j);
            }
            if (sum == d) count++;
        }
        return count;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);

        birthday(list, 3,2);
    }
}
