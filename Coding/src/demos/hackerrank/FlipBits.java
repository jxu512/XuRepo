package demos.hackerrank;

public class FlipBits {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        // Write your code here
        long r = 0;
        for (int i=0;i<32;i++) {
            if ((n>>i) % 2 == 0) {
                r += 1L<<i;         // Use 1L to avoid overflow
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(flippingBits(4));
    }
}
