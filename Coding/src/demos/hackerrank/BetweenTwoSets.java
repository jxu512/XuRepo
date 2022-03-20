package demos.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;



class ResultTwSets {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
        int res=0;
        Collections.sort(b);
        a.forEach(n->System.out.print(n+" "));System.out.println();
        b.forEach(n->System.out.print(n+" "));System.out.println();
        //special case
        if(a.size()==1 && a.get(0)==1){
            res=oneA(a,b);
        System.out.println("Result:"+res);

        	return res;
        }
        
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        List<Integer> included=new ArrayList<>();
        sets.add(new ArrayList<Integer>());
        // From a
        for(int i=0;i<a.size();i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> lst: sets) {
                List<Integer> copy=new ArrayList<>(lst);
                copy.add(a.get(i));
                temp.add(copy);
                int num=1;
                for(int n:copy) num*=n;
                if(!included.contains(num)&&isBetweenSets(a,b,num)){
                    res++;
                    included.add(num);
                }
            }
            sets.addAll(temp);
        }
        // From b
        if(isBetweenSets(a,b,b.get(0))) res++;
        System.out.println("sets:"+sets);
        return res;
    }
    private static boolean isBetweenSets(List<Integer> a, List<Integer> b, int num) {
        if(a.size()==0) return false;
        for(int i:a) if(num%i!=0) return false;
        for(int i:b) if(i%num!=0) return false;
        return true;
    }
    private static int oneA(List<Integer> a, List<Integer> b) {
        int res=0;
        for(int i=1;i<=b.get(0);i++) {
            boolean f=true;
            for(int j=0;j<b.size();j++) if(b.get(j)%i!=0){ f=false; break; }
            if(f) res++;
        }
        return res;
    }
}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\tmp\\test.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = ResultTwSets.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
