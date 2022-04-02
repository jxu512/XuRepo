package demos.coding;

/*
Given a list of integers, all numbers are paired except one
Return the lonely number / unpaired number
*/

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
    // Write your code here
    	System.out.println(a);
        Collections.sort(a);
    	System.out.println(a);
        Iterator<Integer> it = a.iterator();
        int num1=-1;
        int num2=-1;
        // Compare numbers in pairs
        while(it.hasNext()) {
            num1=it.next();
            if(it.hasNext()) num2=it.next();
            if(num1==num2) continue;
            else break;
        }
        System.out.println(num1);
        return num1;
    }

}

public class LonelyNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\tmp\\lonelynumber.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("\\s+"))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
