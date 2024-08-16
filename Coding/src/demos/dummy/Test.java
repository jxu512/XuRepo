package demos.dummy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {

        String s = "10 ";
        int[] result = Arrays.asList(s.trim().split(" "))
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(result[0]);
        //System.out.println(result[1]);
        //System.out.println(result[2]);
        Map<String, String> map = new HashMap<>();

        Arrays.sort(new int[] {1,2,3});
    }
}
