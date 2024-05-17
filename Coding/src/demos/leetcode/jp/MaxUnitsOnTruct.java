/*
https://leetcode.com/problems/maximum-units-on-a-truck/description/
*/
package demos.leetcode.jp;

import java.util.Arrays;

public class MaxUnitsOnTruct {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b)->b[1]-a[1]);   // Sort two dimension array
        int total = 0;
        int types = boxTypes.length;
        int remaining = truckSize;
        for (int i=0;i<types;i++) {
            if (remaining <= boxTypes[i][0]) {
                total += remaining * boxTypes[i][1];
                break;
            } else {
                total += boxTypes[i][0] * boxTypes[i][1];
                remaining -= boxTypes[i][0];
            }
        }
        return total;
    }

    public static void main(String[] args) {

        int size = 10;
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        System.out.println(maximumUnits(boxTypes, size));
    }
}
