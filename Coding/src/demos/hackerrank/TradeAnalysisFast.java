package demos.hackerrank;

import java.io.*;
import java.util.*;

public class TradeAnalysisFast {

    //List<List<Integer>> sets = new ArrayList<List<Integer>>();
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[str.length];
            for(int i=0;i<str.length;i++) arr[i]=Integer.parseInt(str[i]);
            List<Integer> temp=new ArrayList<Integer>();
            TradeAnalysisFast sol = new TradeAnalysisFast();
            int sum = sol.calcSum(arr);
            System.out.println(sum);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private int calcSum(int[] arr) {
        
    	long[] prodByLength=new long[arr.length];
    	long sums=0;
    	for(int i=0;i<arr.length;i++) {			// For each element in arr
    		for(int j=prodByLength.length-1;j>=0;j--) {		// For each prod in prodByLength
    			prodByLength[j] = (prodByLength[j] + (j==0?arr[i]:prodByLength[j-1]*arr[i]))%1000000007;
    		}
    	}
    	for(int i=0;i<prodByLength.length;i++) sums = (sums+prodByLength[i]*(i+1))%1000000007;
    	return (int)sums;
    }

}

/*
Input:
3
1 2 3
output: 46

10
53 73 78 31 85 33 70 85 18 63
Output: 779739943

20
172 992 341 672 697 727 164 216 491 647 494 633 791 588 730 950 528 823 548 758
Output: 381335657

*/
