package demos.coding;

import java.util.Arrays;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        
        int num = 0;
        int[][] matrix = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(matrix[i],-1);
        
        num = findPaths(m,n,matrix);
        return num;
    }
    
    private int findPaths(int m, int n, int[][] matrix) {
        
        if(m==1 || n==1) return 1;
        if(m==2 && n==2) return 2;
        if(matrix[m][n]!=-1) return matrix[m][n];
        matrix[m][n] = findPaths(m-1,n,matrix)+findPaths(m,n-1,matrix);
        return matrix[m][n];
    }
    
    public static void main(String[] args) {
    	
    	UniquePaths paths = new UniquePaths();
    	System.out.println("Number of paths:"+paths.uniquePaths(10, 10));
    }
}
