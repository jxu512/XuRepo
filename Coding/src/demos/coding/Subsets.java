package demos.coding;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Character>> result;
	ArrayList<Character> temp = new ArrayList<Character>();
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	char[] numbers = { 'a','b','c' };
    	Subsets sub = new Subsets();
    	List<List<Character>> res = sub.getSubs(numbers);
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
        // base condition
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
		// case 1 : we pick the element
        temp.add(nums[index]);
        subs(nums, index+1); // move ahead
        temp.remove(temp.size()-1);
        
		// case 2 : we don't pick the element
        subs(nums, index+1); // move ahead
    }
}