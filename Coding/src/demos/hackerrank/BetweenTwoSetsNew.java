package demos.hackerrank;

import java.util.Arrays;
import java.util.List;

public class BetweenTwoSetsNew {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int lcm = 1;
        for (int i=0;i<a.size();i++) {
            lcm = leastCommonMultiple(lcm, a.get(i));
        }
        int gcd = greatestCommonDivisor(b.get(0), b.get(1));;
        for (int i=2;i<b.size();i++) {
            gcd = greatestCommonDivisor(gcd, b.get(i));
        }

        if ( gcd % lcm != 0) return 0;
        return gcd / lcm -1;
    }

    private static int greatestCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return greatestCommonDivisor(b, a % b);
    }
    private static int leastCommonMultiple(int a, int b) {
        int lcm = b;
        while ( b%a != 0) lcm += b;
        return lcm;
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(2,4);
        List<Integer> b = Arrays.asList(16,32,96);
        getTotalX(a, b);
    }
}

