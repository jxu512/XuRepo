package demos.hackerrank;
/*
Determine if removing one char from string making remaing sring palindronme.
Return the index of that char, or -1 if no such char
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class ResultPalindromeIndex {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
    // Write your code here
    if(isPalindrome(s)) return -1;
    
        int breakIndex = -1;
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) { breakIndex=i; break; }
        }
        if (breakIndex==-1) return -1;
            if(isPalindrome(s.subSequence(0, breakIndex)+s.substring(breakIndex+1))) return breakIndex;
            else if(isPalindrome(s.subSequence(0, s.length()-1-breakIndex)+s.substring(s.length()-breakIndex))) return s.length()-1-breakIndex;
            else return -1;
        }

    private static boolean isPalindrome(String s) {
        if(s.length()==1) return true;
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}

public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultPalindromeIndex.palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
