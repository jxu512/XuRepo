package demos.hackerrank;

import java.io.*;
import java.util.*;

public class TradeAnalysisIterative {

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
            TradeAnalysisIterative sol = new TradeAnalysisIterative();
            int sum = sol.calcSum(arr);
            System.out.println(sum);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private int calcSum(int[] arr) {
        
    	long sum=0l;
    	List<List<Integer>> sets = new ArrayList<List<Integer>>();
    	List<List<Integer>> temp = new ArrayList<List<Integer>>();
    	sets.add(new ArrayList<>());		// Empty set as seed
    	for(int i=0;i<arr.length;i++) {
    		temp = new ArrayList<List<Integer>>();
    		for(List<Integer> lst: sets) {
    			List<Integer> copy = new ArrayList<>(lst);
    			copy.add(arr[i]);
    			temp.add(copy);
    			sum = (sum+curVal(copy))%1000000007;
    		}
    		sets.addAll(temp);
    	}
    	System.out.println(sets.size());
    	return (int)sum;
    }
    private long curVal(List<Integer> list){
        long sum=1l;
        for(Integer i:list) sum=(sum*i)%1000000007;
        return sum*list.size();
    }
}

/*
Input:
10
53 73 78 31 85 33 70 85 18 63
Output:
779739943

20
172 992 341 672 697 727 164 216 491 647 494 633 791 588 730 950 528 823 548 758
381335657

*/
