package demos.hackerrank;

import java.util.List;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] arr = 
			{
					5, 2,-8,1,5,-9
			};
		int[] res = maxSubarray(arr);
	}
	public static int[] maxSubarray(int[] arr)
	{
            int maxSA = arr[0]; // max sub array
            int maxSS = arr[0]; // max sub sequences
            int max = arr[0];

            int n = arr.length;
            for (int i = 1; i < n; i++)
            {
                max = Math.max(max + arr[i], arr[i]);
                maxSA = Math.max(maxSA, max);

                maxSS = Math.max(Math.max(maxSS, arr[i]), maxSS + arr[i]);
            }
            return new int[] { maxSA, maxSS };
        }
}