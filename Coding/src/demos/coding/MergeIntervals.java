package demos.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {
     
        if(intervals.length==1) return intervals;
        
        List<int[]> newIntervals = new ArrayList<int[]>();
        // Order by start
        Arrays.sort(intervals, Comparator.comparingInt(interval->interval[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i=1;
        while(i<intervals.length) {

            int s=intervals[i][0];
            int e=intervals[i][1];
            if(s <= end) { //Merge
                if(e>end) end = e;
            }
            else{           // New interval
                newIntervals.add(new int[] {start, end} );
                start = s;
                end = e;
            }
            if(i==intervals.length-1) {      // Add last one
                newIntervals.add(new int[] {start, end} );
            }
            i++;
        }
        int[][] result = new int[newIntervals.size()][2];
        for(int k=0;k<result.length;k++) result[k]=newIntervals.get(k);
        return result;
    }
    
    public static void main(String[] args) {
    	
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
	    	int lines = Integer.parseInt(br.readLine());
			int[][] arr = new int[lines][2];
	    	for(int i=0;i<lines;i++) {
	    		String[] s = br.readLine().trim().split(" ");
	    		arr[i][0]=Integer.parseInt(s[0]);
	    		arr[i][1]=Integer.parseInt(s[1]);
	    	}
	    	
	    	MergeIntervals intervals = new MergeIntervals();
	    	intervals.merge(arr);
	    }
	    catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
    }
}