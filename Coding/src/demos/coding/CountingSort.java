package demos.coding;

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

class Result2 {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     * 
     * Assumption: numbers are between 1 and 100
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
    	
        List<Integer> result = new ArrayList<Integer>(arr.size());
        int[] counts=new int[100];
        
        for(int i=0;i<arr.size();i++) result.add(0);
        arr.forEach(num->counts[num]++);
        for(int i=0, k=0;i<counts.length;i++) {
            if(counts[i]>0) 
              for(int j=0;j<counts[i];j++) result.set(k++, i);
        }
        return result;
    }

}

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\tmp\\test.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result2.countingSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
