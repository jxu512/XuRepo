package demos.basics;

import java.math.BigDecimal;

public class BigDecimalEquals {

    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("1.01");
        System.out.println("d1 scale:" + d1.scale());
        BigDecimal d2 = new BigDecimal("1.010");
        System.out.println("d2 scale:" + d2.scale());
        System.out.println(d1.equals(d2));
        System.out.println(d1.compareTo(d2));

        BigDecimal d3 = new BigDecimal(1.01f);
        System.out.println("d3 scale:" + d3.scale());
        BigDecimal d4 = new BigDecimal(1.01d);
        System.out.println("d4 scale:" + d4.scale());
        System.out.println(d3.equals(d4));
        System.out.println(d3.compareTo(d4));
    }
}
