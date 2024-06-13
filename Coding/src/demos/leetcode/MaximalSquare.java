/*
https://leetcode.com/problems/maximal-square/description/
 */

package demos.leetcode;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = m < n ? m : n;
        int[][] dp = new int[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (matrix[i][j] == '1') dp[i][j] = 1;
            }
        }

        for (int s=2;s<=min;s++) {
            for (int i=0;i<=m-s;i++) {
                for (int j=0;j<=n-s;j++) {
                    if (dp[i][j] == (s-1)*(s-1)) {
                        boolean expand = true;
                        for (int k=0;k<s;k++) expand = expand && matrix[i+s-1][j+k]=='1' && matrix[i+k][j+s-1]=='1';
                        if (expand) dp[i][j] = s * s;
                    }
                }
            }
        }

        int max = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) max = max > dp[i][j] ? max : dp[i][j];
        }

        return max;
    }

    public static void main(String[] args) {

        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
    }
}
