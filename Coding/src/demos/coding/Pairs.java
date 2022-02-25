package demos.coding;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class ResultPairs {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
        Collections.sort(arr);
        List<Integer> arr1 = new ArrayList<>(arr);
        List<Integer> usedIndex = new ArrayList<>(arr);;
        
        for(int i=0;i<arr1.size();i++){
            arr1.set(i, arr1.get(i)+k);
        }
        
        int k1=0, k2=0;
        int count = 0;
        while(k1<arr.size() && k2<arr1.size()) {
            if(arr.get(k1)==arr1.get(k2) && !usedIndex.contains(k2)) {
            	count++;
            	usedIndex.add(k1);
            	k1++;
            	k2++;
            }
            else if(arr.get(k1)<arr1.get(k2)) k1++;
            else k2++;
        }
        System.out.println(arr);
        System.out.println(arr1);
        System.out.println(count);
        return count;
    }

}

public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = ResultPairs.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
