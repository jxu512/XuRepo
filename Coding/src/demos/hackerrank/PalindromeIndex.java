package demos.hackerrank;

public class PalindromeIndex {
    public static int palindromeIndex(String s) {
        // Write your code here
        int idx = isPalindrome(s);

        String s1 = s.substring(0,idx) + s.substring(idx+1);
        if (isPalindrome(s1) == -1) return idx;
        s1 = s.substring(0,s.length()-1-idx) + s.substring(s.length()-idx);
        if (isPalindrome(s1) == -1) return s.length()-1-idx;

        return -1;
    }

    // return: -1: is palindrom, i: break point
    private static int isPalindrome(String s) {

        if (s.length()==1) return -1;

        for (int i=0;i<s.length()/2;i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "";
        palindromeIndex(s);

    }
}
