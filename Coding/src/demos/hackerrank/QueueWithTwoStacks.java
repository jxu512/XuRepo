package demos.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class QueueWithTwoStacks {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        StackQueue<Integer> queue = new StackQueue<>();
        int q = readInputLine()[0];
        for (int i=0;i<q;i++) {
            int[] query = readInputLine();
            switch (query[0]) {
                case 1:
                    queue.enqueue(query[1]);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.print();
            }
        }
    }
    // For hackerrang
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] readInputLine() throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return Arrays.asList(reader.readLine().trim().split(" "))
                .stream()
                .mapToInt(Integer::new)
                .toArray();
    }
}

class StackQueue<T> {
    private Stack<T> stack1, stack2;    // stact1: stack order, stact2: queue ordr

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T data) {
        stack1.push(data);
    }
    public T dequeue() {
        moveStacksWhenNeeded();
        return stack2.pop();
    }
    public void print() {
        moveStacksWhenNeeded();
        System.out.println(stack2.peek());

    }
    private void  moveStacksWhenNeeded() {
        if (!stack1.isEmpty() && stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
    }
}