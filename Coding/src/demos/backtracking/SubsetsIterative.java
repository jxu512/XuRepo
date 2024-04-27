package demos.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsIterative {
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	//char[] arr = { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u' };
        char[] arr = { 'a','b','c','d' };
    	SubsetsIterative sub = new SubsetsIterative();
    	List<List<Character>> res = sub.getSubs(arr);
    	//System.out.println(res);
    }
    /**
     * 
     * @param nums
     * @return
     */
    public List<List<Character>> getSubs(char[] arr) {
    	List<List<Character>> result = new ArrayList<List<Character>>();
        result.add(new ArrayList<Character>());		// Empty set is the seed, if not wanted, exclude at end
        for(int i=0;i<arr.length;i++) {
        	List<List<Character>> temp = new ArrayList<>();
        	for(List<Character> r : result) {
        		List<Character> copy = new ArrayList<>(r);
        		copy.add(arr[i]);
        		if(copy.size()<=3) 		// For fixed size
        			temp.add(copy);
        	}
        	result.addAll(temp);
        }
        // Exclude if empty set not wanted
        result.remove(new ArrayList<Character>());
    	//System.out.println(result);
        for(List<Character> lst:result) {
        	if(lst.size()==3) System.out.print(lst+", ");
        }
        return result;
    }
}