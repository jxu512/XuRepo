package demos.coding;

/*
n nodes with list of equally weighted edges between nodes. find shortest routes from 
start node s to all other nodes.
return list of integers of distances.
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



class ResultBFS {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
        int unit = 6;
    	// Result
    	List<Integer> result = new ArrayList<Integer>();
    	List<Integer> processed = new ArrayList<Integer>();
    	// Queue for BFS
    	Queue<Integer> queue = new LinkedList<Integer>();
    	// Init to unreachable
    	for(int i=0;i<n;i++) result.add(-1);
    	int depth=0;
    	queue.add(s);
    	processed.add(s);
    	int currentDepthCount=queue.size();
    	while (!queue.isEmpty()) {
    		// Find next reachable nodes
    		int current = queue.poll();
    		currentDepthCount--;
    		for(int i=0;i<edges.size();i++) {
    			if(edges.get(i).contains(current)) {
    				int next = edges.get(i).get(0)!=current?edges.get(i).get(0):edges.get(i).get(1);
    				// Record next if not processed already
    				if(!processed.contains(next)) {
	    				result.set(next-1, (depth+1)*unit);	// Depth for next is depth+1
	    				queue.offer(next);	// Add to queue
	    				processed.add(next);
    				}
    			}
    		}
    		if(--currentDepthCount==0) {depth++; currentDepthCount=queue.size(); }
    	}
    	result.remove(s-1);// Remove self
    	System.out.println(result);
    	return result;
    }

}

public class BFS_Search {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\tmp\\test.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
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

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = ResultBFS.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*
Sample input:
2
4 2
1 2
1 3
1
3 1
2 3
2
Sample output:
6 6 -1
-1 6

*/
