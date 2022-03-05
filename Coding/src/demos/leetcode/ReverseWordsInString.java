package demos.leetcode;

public class ReverseWordsInString {
    public String reverseWordsSingleSpace(String s) {
        
    	// " " will split with single space, if there are multiple, additional spaces are preserved
    	// \\s+ will split with any number of spaces
        String[] words = s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++) {
            sb.append(reverse(words[i]));
            if(i<words.length-1) sb.append(" ");
        }
        return sb.toString();
    }
    private String reverse(String s){
        char[] sc = s.toCharArray();
        if(s==null ||s.length()==1) return s;
        for(int i=0;i<sc.length/2;i++) {
            char c=sc[i];
            sc[i]=sc[s.length()-1-i];
            sc[s.length()-1-i]=c;
        }
        return new String(sc);
    }

    public String reverseWordsMultiSpace(String s) {
    
        String[] words = s.split("\\s+");
        String[] spaces = s.split("\\S+");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++) {
            sb.append(reverse(words[i]));
            if(i<words.length-1) sb.append(spaces[i+1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	
    	ReverseWordsInString reverse = new ReverseWordsInString();
    	String s = "This is  a   test    string.";
    	System.out.println(reverse.reverseWordsSingleSpace(s));
    	System.out.println(reverse.reverseWordsMultiSpace(s));
    	
    }
}