package demos.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ResultCutTree {
	static int level=0;
	static int exits=0;
    /*
     * Complete the 'cutTheTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY data
     *  2. 2D_INTEGER_ARRAY edges
     */

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
    // Write your code here
        int n=data.size();
        int[] visited=new int[n+1];
        int[] total=new int[n+1];
        int root=edges.get(edges.size()-1).get(0);
        visited[root]=1;
        calcTotal(data, edges,root,total,visited);

        int value=0;
        int sum=total[root]/2;
        int diff=sum;
        for(int i=1;i<total.length;i++){
            if(Math.abs(total[i]-sum)<diff){
            value = total[i];
            diff=Math.abs(total[i]-sum);
            }
        }
        int result=Math.abs(total[root]-value-value);
        System.out.println("Value:"+result);
        return result;
    }
    private static void calcTotal(List<Integer> data, List<List<Integer>>edges,int node, int[] total, int[] visited){
        int[] c = findChildren(edges, node, visited);
        visited[c[0]]=1;
        visited[c[1]]=1;
        if(c[0]==0 && c[1]==0) {
        	if(node>0) total[node]=data.get(node-1);
            //if(exits%50==0) 
            	System.out.println("Exits:"+exits);exits++;
            return;
        }
        if(level%1000==0) System.out.println("Level:"+level);level++;
        if(c[0]>0) calcTotal(data, edges,c[0],total,visited);
        if(c[1]>0) calcTotal(data, edges,c[1],total,visited);
        total[node] = data.get(node-1)+total[c[0]]+total[c[1]];
    }
    private static int[] findChildren(List<List<Integer>> edges, int parent,int[] visited){
        int[] children= {0,0};
        int num=0;
       for(int i=0;i<edges.size();i++) {
            int node1=edges.get(i).get(0);
            int node2=edges.get(i).get(1);
            if((node1==parent&&visited[node2]==0)||(node2==parent&&visited[node1]==0)) {
                children[num]=node1==parent?node2:node1;
                if(++num==2) break;
                else continue;
            }
       }
    return children;
    }
}

public class CutTheTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("G:\\GITHub\\XuRepo\\Coding\\src\\demos\\hackerrank\\data\\cutTheTree\\case19.txt")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\tmp\\test.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultCutTree.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
Sample input:
6
100 200 100 500 100 600
1 2
2 3
2 5
4 5
5 6
Output:
400
*/
