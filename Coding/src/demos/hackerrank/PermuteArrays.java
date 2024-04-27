package demos.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
There are two -element arrays of integers,  and . Permute them into some  and  such that the relation  holds for all  where .

There will be  queries consisting of , , and . For each query, return YES if some permutation ,  satisfying the relation exists. Otherwise, return NO.

 */
public class PermuteArrays {
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        for (int i=0;i<A.size();i++) {
            A.set(i, A.get(i)-k);
        }
        Collections.sort(A);
        Collections.sort(B);

        for (int i=0;i<A.size();i++) {
            if (A.get(i) >= 0) {
                return "YES";
            }
            boolean matched = false;
            for (int j=0;j<B.size();j++) {
                if (B.get(j) != -1 && B.get(j) + A.get(i) >=0) {
                    B.set(j, -1);
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        int k=10;
        List<Integer> A, B;
        A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(3);
        B = new ArrayList<>();
        B.add(7);
        B.add(8);
        B.add(9);
        System.out.println(twoArrays(k, A, B));
    }
}
