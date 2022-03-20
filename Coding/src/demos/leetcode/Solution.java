package demos.leetcode;

public class Solution {
    public double largestTriangleArea(int[][] points) {
        
        double largest=0;
        int len = points.length;
        for(int i=0;i<len-2;i++) {
            for(int j=i+1;j<len-1;j++) {
                for(int k=j+1;k<len;k++) {
                    int x1=points[i][0];
                    int y1=points[i][1];
                    int x2=points[j][0];
                    int y2=points[j][1];
                    int x3=points[k][0];
                    int y3=points[k][1];
                    double s = 0.5*Math.abs((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1));
                    largest = s<largest?largest:s;
                }
            }
        }
        return largest;
    }
}