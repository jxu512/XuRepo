package demos.coding;

/*
Given positive integer array, and a target number x
Find a number n, so that if we replace all numbers greater than n with n in array, 
the sum of updated array is closest to x
*/

class MutatedArrayClosetToTarget {
    public int findBestValue(int[] arr, int target) {
        
        int maxElement = 0;
        int arrSum = 0;
        
        // Find the max value and the upper bound of the search range.
        for(int num : arr) {
            maxElement = maxElement<num?num:maxElement;
            arrSum += num;
        }
        
        // If the sum is smaller than the target the greatest number is the answer.
        if(arrSum <= target) {
            return maxElement;
        }
        
        // Possible lower/upper of the possible pick
        int lower = 0;
        int upper = maxElement;
        int lowerSum = getSum(arr, lower);
        int upperSum = getSum(arr, upper);
        
        
        // Do binary search between lower and upper
        while(Math.abs(lower - upper) != 1) {
            
            int middle = (lower + upper) / 2;
            int midSum = getSum(arr, middle);
            
            if(midSum < target) {
                lower = middle;
                lowerSum = midSum;
            } else if(midSum > target) {
                upper = middle;
                upperSum = midSum;
            } else {
                return middle;
            }
        }
        
        // Determine which one is closer to the target.
        if(Math.abs(lowerSum - target) <= Math.abs(upperSum - target)) {
            return lower;
        } else {
            return upper;
        }
        
    }
    
    // Get the sum of the chosen number
    private int getSum(int[] arr, int number) {
        int sum = 0;
        
        for(int num : arr) {
            sum += num<number?num:number;
        }
        
        return sum;
    }
}