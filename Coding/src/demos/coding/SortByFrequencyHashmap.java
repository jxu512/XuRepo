package demos.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByFrequencyHashmap {
    public String frequencySort(String s) {
        
        Map<Character,Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            
        	if(map.get(s.charAt(i))==null) map.put(s.charAt(i), 1);
        	else map.put(s.charAt(i), 1+(int)map.get(s.charAt(i)));
        }
        
        // Sort
        //Map.Entry<Character,Integer>[] arr = (Entry<Character, Integer>[]) map.entrySet().stream().toArray();	// Won't work
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        int[][] arr = new int[list.size()][2];
        Iterator<Map.Entry<Character,Integer>> it = list.iterator();
        for(int i=0;i<list.size();i++) {
        	Map.Entry<Character, Integer> entry = it.next();
        	arr[i][0]=entry.getKey();        	
        	arr[i][1]=entry.getValue();
        }
        Arrays.sort(arr, Comparator.comparingInt(entry->entry[1]));
        
        // Form the string
        for(int i=arr.length-1;i>=0;i--) {
            for(int j=0;j<(int)arr[i][1];j++) sb.append((char)arr[i][0]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	
    	SortByFrequencyHashmap sort = new SortByFrequencyHashmap();
    	String s = "AxayBBcccD";
    	System.out.println(s);
    	System.out.println(sort.frequencySort(s));
    }
}