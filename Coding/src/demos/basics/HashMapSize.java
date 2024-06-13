package demos.basics;

import java.util.HashMap;
import java.util.Map;

public class HashMapSize {

    // Default size = 16
    Map<String,String> map = new HashMap<>();

    public static void main(String[] args) {
        // In put method: tab[i = (n - 1) & hash]
        // hash is converted to bucket / array index: (n - 1) & hash, where n is capacity which usually is 2**k
        // which is effectly mod (%)

        int n = 32;
        int hash = 532;
        System.out.format("(n-1)&hash=%d, hash%%n=%d\n", (n-1)&hash, hash%n);
    }
}
