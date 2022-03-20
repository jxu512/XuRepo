package demos.hackerrank;

import java.io.*;
import java.util.*;

public class TradeAnalysisBacktracking {
    long sum = 0;
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
            TradeAnalysisBacktracking sol = new TradeAnalysisBacktracking();
            sol.calcSum(arr, 0,temp);
            System.out.println(sol.sum);
            //System.out.println(sol.sets);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void calcSum(int[] arr, int i, List<Integer> temp) {
        
        if(i>=arr.length) {
        	sum = (sum+ curVal(temp))%1000000007;
        	//sets.add(new ArrayList(temp));
        	return;
        }
        temp.add(arr[i]);
        calcSum(arr, i+1, temp);
        temp.remove(temp.size()-1);
        calcSum(arr, i+1, temp);
        
    }
    private long curVal(List<Integer> list){
        long sum=1;
        for(int i=0;i<list.size();i++) sum=sum*list.get(i);
        return sum*list.size();
    }
}

/*
Input:
10
53 73 78 31 85 33 70 85 18 63
Output:
779739943

*/
