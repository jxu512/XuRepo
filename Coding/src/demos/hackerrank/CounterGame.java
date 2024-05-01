package demos.hackerrank;

public class CounterGame {
    public static String counterGame(long n) {
        // Write your code here
        if (n==1) return "Richard";

        boolean isLouiseTurn = true;
        while (n>1) {
            if (isPowerOfTwo(n)) {
                n /= 2;
            } else {
                n = subtractNextPowerOfTwo(n);
            }
            isLouiseTurn = !isLouiseTurn;
        }
        return isLouiseTurn ? "Richard" : "Louise";
    }
    public static long subtractNextPowerOfTwo(long n) {

        long tmp = 0x40_00_00_00_00_00_00_00L;
        while ((tmp & n) == 0) tmp >>= 1;
        return n - tmp;
    }
    private static boolean isPowerOfTwo(long n) {
        while (n>1) {
            if (n%2 != 0) return false;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {

        counterGame(6);
    }
}
