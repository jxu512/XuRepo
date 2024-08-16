package demos.basics;

/*
Java does not have hoisting like in JavaScript"
Hoisting is necessary for mutually recursive functions (and everything else that uses variable references in a circular manner)

However, below is similar in a way that isEven() calls isOdd() before it is defined.
*/
public class Hoisting {

    public static void main(String[] args) {
        Hoisting hoisting = new Hoisting();
        System.out.println(hoisting.isEven(7));
        //System.out.println(hoisting.isOdd(7));
    }
    private boolean isEven(int n) {
        return n == 0 || !isOdd(n);
    }
    private boolean isOdd(int n) {
        return !isEven(n-1);
    }
}
