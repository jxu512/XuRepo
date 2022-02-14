package demos.coding;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result;
	ArrayList<Integer> temp = new ArrayList<Integer>();
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	int[] numbers = { 1,2,3 };
    	Subsets sub = new Subsets();
    	List<List<Integer>> res = sub.getSubsets(numbers);
    	System.out.println(res);
    }
    /**
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> getSubsets(int[] nums) {
        result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return result;
        
        subsets(nums, 0);
        return result;
    }
    /**
     * 
     * @param nums
     * @param temp
     * @param index
     */
    private void subsets(int[] nums, int index) {
        // base condition
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
		// case 1 : we pick the element
        temp.add(nums[index]);
        subsets(nums, index+1); // move ahead
        temp.remove(temp.size()-1);
        
		// case 2 : we don't pick the element
        subsets(nums, index+1); // move ahead
    }
}