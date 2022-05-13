/*
Sort long strings
*/
package demos.hackerrank;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


class ResultBigSort {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    // 1. Lambda way
    public static List<String> bigSorting(List<String> unsorted) {

        Collections.sort(unsorted, (s1,s2)-> {
	            if(s1.length()<s2.length()) return -1;
	            else if(s1.length()>s2.length()) return 1;
	            
	            for(int i=0;i<s1.length();i++) {
	                if(s1.charAt(i)<s2.charAt(i)) return -1;
	                else if(s1.charAt(i)>s2.charAt(i)) return 1;
	            }
	            return 0;                
        	} );
        
        System.out.println("Lambda:"+unsorted);
        return unsorted;
    }

    // 2. Local class way
    public static List<String> bigSorting2(List<String> unsorted) {

    	Comparator<String> c = new Comparator<String>(){
    	    
            public int compare(String s1, String s2){
                if(s1.length()<s2.length()) return -1;
                else if(s1.length()>s2.length()) return 1;
                
                for(int i=0;i<s1.length();i++) {
                    if(s1.charAt(i)<s2.charAt(i)) return -1;
                    else if(s1.charAt(i)>s2.charAt(i)) return 1;
                }
                return 0;                
                
            }
        };
        Collections.sort(unsorted, c );
        
        System.out.println("Local class:"+unsorted);
        return unsorted;
    }
    // 3. Anonymous class way
    public static List<String> bigSorting3(List<String> unsorted) {

        Collections.sort(unsorted, new Comparator<String>(){
    
            public int compare(String s1, String s2){
                if(s1.length()<s2.length()) return -1;
                else if(s1.length()>s2.length()) return 1;
                
                for(int i=0;i<s1.length();i++) {
                    if(s1.charAt(i)<s2.charAt(i)) return -1;
                    else if(s1.charAt(i)>s2.charAt(i)) return 1;
                }
                return 0;                
                
            }
        } );
        
        System.out.println("Anomymous class:"+unsorted);
        return unsorted;
    }
    // 4 . Normal class way
    public static List<String> bigSorting1(List<String> unsorted) {

        Collections.sort(unsorted, new MyComparator() );
        
        System.out.println("Normal class:"+unsorted);
        return unsorted;
    }
}
class MyComparator implements Comparator<String>{
    
            public int compare(String s1, String s2){
                if(s1.length()<s2.length()) return -1;
                else if(s1.length()>s2.length()) return 1;
                
                for(int i=0;i<s1.length();i++) {
                    if(s1.charAt(i)<s2.charAt(i)) return -1;
                    else if(s1.charAt(i)>s2.charAt(i)) return 1;
                }
                return 0;                
                
            }
        }

public class BigSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\tmp\\test.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = ResultBigSort.bigSorting(unsorted);
        result = ResultBigSort.bigSorting1(unsorted);
        result = ResultBigSort.bigSorting2(unsorted);
        result = ResultBigSort.bigSorting3(unsorted);
        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
