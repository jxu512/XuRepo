/*
https://leetcode.com/problems/unique-paths/
*/
package demos.dynamicprogramming;

import java.util.Arrays;

class UniquePaths {
    public int uniquePathsRecursion(int m, int n) {
        
        int num = 0;
        int[][] matrix = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(matrix[i],-1);
        
        num = findPathsWithRecursion(m,n,matrix);
        return num;
    }
    
    private int findPathsWithRecursion(int m, int n, int[][] matrix) {
        
        if(m==1 || n==1) return 1;
        if(matrix[m][n]!=-1) return matrix[m][n];
        matrix[m][n] = findPathsWithRecursion(m-1,n,matrix)+findPathsWithRecursion(m,n-1,matrix);
        return matrix[m][n];
    }

    private int findPathsTable(int m, int n) {
        int num = 0;
        int[][] matrix = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(matrix[i],-1);

        for (int i=1;i<=n;i++) {
            matrix[1][i] = 1;
        }
        for (int i=1;i<=m;i++) {
            matrix[i][1] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m][n];
    }
    public static void main(String[] args) {
    	
    	UniquePaths paths = new UniquePaths();
    	System.out.println("Number of paths:"+paths.uniquePathsRecursion(10, 10));
        System.out.println("Number of paths:"+paths.findPathsTable(10, 10));
    }
}
