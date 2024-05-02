package demos.hackerrank;

import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Operation> lastOperations = new Stack<>();
        int q = scanner.nextInt();
        int type, num;
        String val;
        for (int i=0;i<q;i++) {
            type = scanner.nextInt();
            switch (type) {
                case 1:
                    val = scanner.nextLine().trim();
                    sb.append(val);
                    lastOperations.push(new Operation(type, val));
                    break;
                case 2:
                    num = scanner.nextInt();
                    lastOperations.push(new Operation(type, sb.substring(sb.length()-num)));
                    sb.delete(sb.length()-num, sb.length());
                    break;
                case 3:
                    num = scanner.nextInt();
                    System.out.println(sb.charAt(num-1));
                    break;
                case 4:
                    Operation op = lastOperations.pop();
                    if (op.type == 1) {
                        sb.delete(sb.length()-op.number, sb.length());
                    } else {
                        sb.append(op.val);
                    }
            }
        }
        scanner.close();
    }
}

class Operation {
    int type;
    int number;
    String val;

    public Operation(int type, String val) {
        this.type = type;
        this.number = val.length();
        this.val = val;
    }
}