/*
https://leetcode.com/problems/container-with-most-water/
*/
package demos.leetcode;

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max=0;
        int len=height.length;
        int left=0;
        int right=len-1;
        while(left<right) {
            int m=(right-left)*Math.min(height[left],height[right]);
            if(max<m) max=m;
            if(height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }
}