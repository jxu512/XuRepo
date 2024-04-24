package demos.coding;

/*
 * Encode string by shifting chars k position
 * char can be used in comparison
 * char and int both have 2 bytes. When appending to StringBuilder need to convert to (char) to treat as char, 
 * or it may be treated as int
 */
public class CaesarCipher {

    public String encode(String s, int k) {
    // Write your code here

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
             if(s.charAt(i)>='a' && s.charAt(i)<='z') {
                 ch += (k%26);
                 // Note: convert: (char) (*), have to use full parenthesis
                 sb.append((char)(ch<='z'?ch:(ch-'z'+'a'-1)));	// Correct, treat as char
                 //sb1.append((ch<='z'?ch:(ch-'z'+'a'-1)));		// Incorrect, treated as integer
             } else if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
                 ch += (k%26);
                 sb.append((char)(ch<='Z'?ch:(ch-'Z'+'A'-1)));
             } else {
            	 sb.append(ch);
            	 sb1.append(ch);
             }
        }
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "abc-xyz";
        System.out.println(s);
    	CaesarCipher cipher = new CaesarCipher();
    	cipher.encode(s, 2);
    }
}