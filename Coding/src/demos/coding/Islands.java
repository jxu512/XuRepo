package demos.coding;

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
        
        Queue<int[]> queue=new LinkedList<int[]>();
        int w=grid.length;
        int h=grid[0].length;
        int numOfIslands=0;
        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                int[] arr={i,j};
                if(grid[i][j]=='1') {
                    addToQueue(i,j,grid,queue);
                    if(findIsland(grid,queue)) numOfIslands ++;
                }
            }
        }
        return numOfIslands;
    }
    
    private boolean  findIsland(char[][] grid, Queue<int[]>queue) {
        
        while(!queue.isEmpty()) {
            int[] arr1 = queue.remove();
            int i=arr1[0];
            int j=arr1[1];
            if(j-1>=0 && grid[i][j-1]=='1') addToQueue(i,j-1,grid,queue);
            if(i-1>=0 && grid[i-1][j]=='1') addToQueue(i-1,j,grid,queue);
            if(j+1<grid[0].length && grid[i][j+1]=='1') addToQueue(i,j+1,grid,queue);
            if(i+1<grid.length && grid[i+1][j]=='1') addToQueue(i+1,j,grid,queue);
        }
        return true;
    }
    private void addToQueue(int i,int j,char[][] grid, Queue<int[]> queue) {
        int arr[]={i,j};
        queue.add(arr);
        grid[i][j]='2';
    }
    
    public static void main(String[] args) {
    	Islands islands = new Islands();
    	char[][] grid=  {
    			{'1','1','1'},
    			{'0','1','0'},
    			{'1','0','1'}
    	};
    	int num = islands.numIslands(grid);
    	System.out.println("Number of Islands:"+num);
    }
}