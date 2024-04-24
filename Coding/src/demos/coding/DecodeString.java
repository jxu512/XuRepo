package demos.coding;
/*
String is coded as "3[a]2[b2[x]3[y2[z]]]4[c]", where 3[a] represents aaa etc
Return decoded string

*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecodeString {

   Pattern p = null;
   Matcher m = null;
   
   public DecodeString() {
	   p = Pattern.compile("\\d+\\[[a-z]+\\]");
	   
   }
   public String decode(String s) {

	   Matcher m = null;
	   
	   int start, end;
	   while(true) {
		   m = p.matcher(s);
		   if(!m.find()) break;
		   start = m.start();
		   end = m.end();
		   s = decodeCurrent(s, start,end);
	   }
	   
	   System.out.println(s);
       return s;
    }
    
    private String decodeCurrent(String s, int start, int end) {

    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(s.substring(0, start));
    	int indexLeft = s.indexOf("[", start);
    	int count = Integer.parseInt(s.substring(start, indexLeft));
    	String current = s.substring(indexLeft+1, end-1);
    	while(count-->0) sb.append(current);
    	sb.append(s.substring(end));
    	return sb.toString();
    }
	public static void main(String[] args) {
    	DecodeString decode = new DecodeString();
		String s = "3[a]2[b2[x]3[y2[z]]]4[c]";
		System.out.println(s);
    	decode.decode(s);
    }
}