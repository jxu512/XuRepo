package demos.dummy;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String s = "10 ";
        int[] result = Arrays.asList(s.trim().split(" "))
                .stream()
                .mapToInt(Integer::new)
                .toArray();
        System.out.println(result[0]);
        //System.out.println(result[1]);
        //System.out.println(result[2]);
    }
}
