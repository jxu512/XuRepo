/*
https://leetcode.com/problems/rotate-image/description/
*/
package demos.leetcode.top;

public class RotateImage {

    // Use tmp matrix, for practice only
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;

        int[][] tmp = new int[n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++) tmp[i][j] = matrix[i][j];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                matrix[j][n-1-i] = tmp[i][j];
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return;

        for (int i=0;i<n/2+1;i++) {
            for (int j=0;j<n/2+1;j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = matrix[n-1-j][i];
                matrix[n-1-j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(matrix);
    }
}
