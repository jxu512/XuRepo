/**
 *  Convert number to binary & find the longest number of zeros eg. 1256 -> 10011101000 -> output 3
 */
package demos.companies.ubs;

public class LongestZerosInNumber {

    public static void main(String[] args) {

        int x = 8;
        int max = 0;
        int count = 0;
        while (x>0) {
            if (x%2 == 0) {
                count ++;
            }
            else {
                if (count > max) max = count;
                count = 0;
            }
            x /= 2;
        }

        System.out.printf("%d\n", max);
    }
}
