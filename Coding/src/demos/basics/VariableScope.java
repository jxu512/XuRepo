package demos.basics;

public class VariableScope {


    public void test() {

        // Local variable must be declared before accessing
        int val2 = 8;
        for (int i=0;i<5;i++) {
            // Local variables not visible outside enclosing block
            int val3 = 0;
        }

        System.out.println(val2);
        //int val2 = 8;
    }
    // Instance variables cab be anywhere, like hoist in JavaScript
    int val1 = 6;
}
