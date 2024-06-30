/*
Type conversion in an expression is done at runtime, so order matters. JavaScript is similar.
 */

package demos.basics;

public class MixOfDataTypes {

    public static void main(String[] args) {
        int a=3, b=5;
        String c="9";

        System.out.println(a + b + c + a + b);  // a and b are summed first then converted to string, conversion is done when c is encountered
        System.out.println(c + b + a);  // Since c is string, a and b are converted to string before concatenating
    }
}
