package demos.bfs;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/

import java.util.LinkedList;
import java.util.Queue;

class Islands {
    public int numIslands(char[][] grid) {
        int ans = 0;

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j] != '1') continue;
                markRecursion(i,j,grid);
                ans ++;
            }
        }
        return ans;
    }

    private void markRecursion(int i, int j, char[][] grid) {
        if (grid[i][j] != '1') return;
        grid[i][j] = '2';       // Mark first to avoid repeating

        if (i>0) markRecursion(i-1, j, grid);
        if (j>0) markRecursion(i, j-1, grid);
        if (i<grid.length-1) markRecursion(i+1, j, grid);
        if (j<grid[0].length-1) markRecursion(i, j+1, grid);
    }
    private void markQueue(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        grid[i][j] = '2';
        while (!queue.isEmpty()) {
            System.out.println("queue: " + queue.size());
            int[] c = queue.poll();
            int m=c[0], n=c[1];
            if (m>0 && grid[m-1][n] == '1') {
                queue.offer(new int[]{m - 1, n});
                grid[m-1][n] = '2';     // Mark first to avoid repeating
            }
            if (n>0 && grid[m][n-1] == '1') {
                queue.offer(new int[]{m, n - 1});
                grid[m][n-1] = '2';
            }
            if (m<grid.length-1 && grid[m+1][n] == '1') {
                queue.offer(new int[]{m + 1, n});
                grid[m+1][n] = '2';
            }
            if (n<grid[0].length-1 && grid[m][n+1] == '1') {
                queue.offer(new int[]{m, n + 1});
                grid[m][n+1] = '2';
            }
        }
    }
    
    public static void main(String[] args) {
    	Islands islands = new Islands();
        //char[][] grid=  { {'1','0','1'}, {'1','1','1'}, {'1','0','1'} };
        char[][] grid= {{'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},{'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},{'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},{'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}};
        int num = islands.numIslands(grid);
    	System.out.println("Number of Islands:"+num);
    }
}