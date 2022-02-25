package demos.coding;

import java.util.Arrays;
import java.util.Comparator;

public class SortByFrequency {
    public String frequencySort(String s) {
        
        // 0-25:a-z, 26-51:A-Z, 52-61:0-9
        int[][] countArr = new int[62][2];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            
            if (s.charAt(i)>='a' && s.charAt(i)<='z') { 
                countArr[s.charAt(i)-'a'][0]=s.charAt(i);
                countArr[s.charAt(i)-'a'][1]++;
            }
            if (s.charAt(i)>='A' && s.charAt(i)<='Z') { 
                countArr[s.charAt(i)-'A'+26][0]=s.charAt(i);
                countArr[s.charAt(i)-'A'+26][1]++;
            }
            if (s.charAt(i)>='0' && s.charAt(i)<='9') { 
                countArr[s.charAt(i)-'0'+52][0]=s.charAt(i);
                countArr[s.charAt(i)-'0'+52][1]++;
            }
        }
        
        // Sort
        //Arrays.sort(countArr, Comparator.comparingInt(count->count[1]));
        ///*
        Arrays.sort(countArr, new Comparator() {
        	public int compare(Object o1, Object o2) {
        				int[] a=(int[])o1;
        				int[]b=(int[])o2;
        				return a[1]==b[1]?a[0]-b[0] : a[1]-b[1];
        			}
        		}
        	);
		//*/
        //
        for(int i=61;i>=0;i--) {
            
            for(int j=0;j<countArr[i][1];j++) sb.append((char)countArr[i][0]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	
    	SortByFrequency sort = new SortByFrequency();
    	String s = "AxayBBcccD";
    	System.out.println(s);
    	System.out.println(sort.frequencySort(s));
    }
}