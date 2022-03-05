package demos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetsBacktracking {
    List<List<Character>> result;
	ArrayList<Character> temp = new ArrayList<Character>();
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	char[] arr = { 'a','b','c' };
    	SubsetsBacktracking sub = new SubsetsBacktracking();
    	List<List<Character>> res = sub.getSubs(arr);
    	System.out.println(res);
    }
    /**
     * 
     * @param nums
     * @return
     */
    public List<List<Character>> getSubs(char[] nums) {
        result = new ArrayList<List<Character>>();
        if(nums==null || nums.length==0) return result;
        
        subs(nums, 0);
        return result;
    }
    /**
     * 
     * @param nums
     * @param temp
     * @param index
     */
    private void subs(char[] nums, int index) {
        // End condition: each iteration must have processed all elements
        if(index >= nums.length) {		// This condition gives all subsets
        	//if(temp.size()==2)		// This condition gives subsets of fixed size only
        		result.add(new ArrayList<>(temp));	// Create new object from temp
            return;
        }
        
		// pick the element
        temp.add(nums[index]);
        subs(nums, index+1);
        temp.remove(temp.size()-1);
        
		// don't pick the element
        subs(nums, index+1);
    }
}