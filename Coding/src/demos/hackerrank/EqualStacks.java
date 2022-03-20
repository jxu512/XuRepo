package demos.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultStacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    	int t1=0, t2=0, t3=0;
    	for (int num:h1) t1+=num;
    	for (int num:h2) t2+=num;
    	for (int num:h3) t3+=num;
        for(int i1=0,i2=0,i3=0;i1<h1.size()||i2<h2.size()||i3<h3.size();){
            if(t1==t2 && t2==t3) return t1;
            int min1 = t1<t2?t1:t2;
            int min = min1<t3?min1:t3;
            if(t1!=min) t1-=h1.get(i1++);
            if(t2!=min) t2-=h2.get(i2++);
            if(t3!=min) t3-=h3.get(i3++);
        }
        return 0;
    }

}

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\tmp\\equalstacks.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\tmp\\test.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultStacks.equalStacks(h1, h2, h3);
        System.out.println("Result:"+result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
Sampe input:
3 4 5
2 3 8
1 3 2 6
2 4 3 2 3

*/
