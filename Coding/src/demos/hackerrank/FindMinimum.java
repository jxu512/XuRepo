package demos.hackerrank;

/*
List<Integer>
Find all subsets of length m, for each subset, find minimum number, 
then pick up maximum of the such minimum value.
*/

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

class Result {
        static int maxMin = 0;
    /*
     * Complete the 'findMaximum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER m
     */

    public static int findMaximum(List<Integer> arr, int m) {
    // Write your code here
        
        // Find all subsets
        List<List<Integer>> subSets = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        findSubset(arr, 0, subSets, current, m);
        System.out.println("\nNumber:"+maxMin);
        return maxMin;
    }

    private static void findSubset(List<Integer> arr, int index, List<List<Integer>> result, List<Integer> current,int m ) {
    	// subsets of length m
        if(current.size()==m) {
            System.out.println(current);
            List<Integer> copy = new ArrayList<>(current);
            result.add(new ArrayList<Integer>(current));
            Collections.sort(copy);
            int min = findMin(copy);
            if(min>maxMin) maxMin = min;
            return;
        }
    	if(index>=arr.size()) return;
    	// Print all subsets
    	//if(index>=arr.size()) { result.add(new ArrayList<Integer>(current)); return; }
    	
        current.add(arr.get(index)); 
        findSubset(arr, index+1, result, current,m);
        current.remove(current.size()-1);
        findSubset(arr, index+1, result, current,m);
    }

	private static int findMin(List<Integer> copy) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<copy.size()-2;i++) {
			int diff =copy.get(i+1)-copy.get(i);
			if(diff<min) min = diff;
		}
		return min;
	}
}

public class FindMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\tmp\\test.txt"));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.findMaximum(arr, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
