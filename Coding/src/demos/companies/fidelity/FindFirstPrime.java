package demos.companies.fidelity;

import java.util.Arrays;
import java.util.OptionalInt;

public class FindFirstPrime {

    public static void main(String[] args) {
        int[] nums = { 4,6,8,13,20 };
        FindFirstPrime findFirstPrime = new FindFirstPrime();
        System.out.println(findFirstPrime.findPrime(nums));
    }
    public int findPrime(int[] nums) {
        OptionalInt prime;

        // Both below styles work
        prime= Arrays.stream(nums).filter(this::isPrime).findFirst();
        prime= Arrays.stream(nums).filter(n->isPrime(n)).findFirst();
        // This does not work because the steam is of integer not FindFirstPrime and isPrime is not static
        //prime= Arrays.stream(nums).filter(FindFirstPrime::isPrime).findFirst();
        // But this works because isPrime1 is atatic
        prime= Arrays.stream(nums).filter(FindFirstPrime::isPrime1).findFirst();

        if (prime.isPresent()) return prime.getAsInt();
        else return -1;
    }
    private boolean isPrime(int n) {

        for (int i=2;i<=Math.sqrt(n);i++) {
            if (n % i ==0) return false;
        }
        return true;
    }
    private static boolean isPrime1(int n) {

        for (int i=2;i<=Math.sqrt(n);i++) {
            if (n % i ==0) return false;
        }
        return true;
    }
}
