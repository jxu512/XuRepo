/*
https://leetcode.com/problems/trapping-rain-water/description/
 */
package demos.leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = height[0];
        for (int i=1;i<len;i++) left[i] = left[i-1] > height[i] ? left[i-1] : height[i];
        right[len-1] = height[len-1];
        for (int i=len-2;i>=0;i--) right[i] = right[i+1] > height[i] ? right[i+1] : height[i];
        int total = 0;
        for (int i=1;i<len-1;i++) total += Math.min(left[i], right[i]) - height[i];
        return total;
    }
}
