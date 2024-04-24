/*
int[][] edges: indicates if two nodes connected
source: start node

sourceToAllNodes()
Find distance from source to all other nodes, return int[] result

sourceToDestination()
Find distance between two nodes
 */

package demos.coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int[][] initEdges () {
        int[][] edges = {
                { 1, 1, 1, 1, 1 },
                { 1, 1, 0, 0, 0 },
                { 1, 0, 1, 0, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 0, 0, 0, 1 }
        };
        return edges;
    }
    public void sourceToAllNodes(int[][] edges, int source) {
        int num = edges.length;
        int[] result = new int[num];
        boolean[] processed = new boolean[num];
        Arrays.fill(result, -1);
        result[source] = 0;
        int depth, depthCount;

        // Breadth first search, any node can be reached by BFS is reachable
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        depth = 0;
        depthCount = queue.size();
        processed[source] = true;
        while (!queue.isEmpty()) {
            int curent = queue.poll();
            processed[curent] = true;
            result[curent] = depth;
            for (int i = 0; i < num; i++) {
                if (edges[curent][i] == 1 && !processed[i]) {
                    queue.offer(i);
                }
            }
            if ( --depthCount == 0 ) {
                depth += 1;
                depthCount = queue.size();
            }
        }
        for (int r : result) {
            System.out.print(r + ",");
        }
    }
    public void sourceToDestination(int[][] edges, int source, int destination) {
        int num = edges.length;
        int[] result = new int[num];
        boolean[] processed = new boolean[num];
        Arrays.fill(result, -1);
        result[source] = 0;
        int depth, depthCount;

        // Breadth first search, any node can be reached by BFS is reachable
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        depth = 0;
        depthCount = queue.size();
        processed[source] = true;
        while (!queue.isEmpty()) {
            int curent = queue.poll();
            processed[curent] = true;
            if ( curent == destination ) {
                System.out.format("\nFrom %s to %s: %d", source, destination, depth);
                return;
            }
            for (int i = 0; i < num; i++) {
                if (edges[curent][i] == 1 && !processed[i]) {
                    queue.offer(i);
                }
            }
            if ( --depthCount == 0 ) {
                depth += 1;
                depthCount = queue.size();
            }
        }
        for (int r : result) {
            System.out.print(r + ",");
        }
    }
    public static void main(String[] args) {

        BFS bfs = new BFS();
        int[][] edges = bfs.initEdges();
        bfs.sourceToAllNodes(edges, 4);
        bfs.sourceToDestination(edges, 4, 2);
    }
}
