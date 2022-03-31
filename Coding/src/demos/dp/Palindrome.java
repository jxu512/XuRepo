package demos.dp;

public class Palindrome {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		System.out.println("Input: "+args[0]+":"+args[0].length());
		System.out.println(p.search(args[0]));
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String search(String str) {
		int len = str.length();
		boolean isParlindrome = false;
		String part1 = null, part2=null;
		int start=0,end=0;
		
		// Possible parlindrome of length i
		for (int i=len;i>1;i--) {
			
			// Check if substring starting at index1 of length i is parlindrome
			int index1=0, index2=0;
			for ( index1=0;index1<=len-i;index1++) {
				
				index2=index1 + i;
				String current_str = str.substring(index1, index2);
				// Check if it is parlindrome
				isParlindrome = isParlindrome(current_str);

				// It is parlindrome
				if(isParlindrome) break;
			}
			if(isParlindrome) {
				start = index1-1;
				end=index2;
				part1 = str.substring(start, start + (end-start)/2);
				part2 = str.substring(start + (end-start)/2+1, end);
				System.out.println("Parlindrome length:"+i+", start at "+index1);
				System.out.println(part1+":"+part2);
				break;
			}
		}
		
		if (isParlindrome) return part1+":"+part2;
		else return "Not a parlindrome";
	}
	/**
	 * 
	 * @return
	 */
	private boolean isParlindrome(String s) {
		for(int start=0,end =s.length()-1;start<end;start++,end--) {
			char c1=s.charAt(start), c2=s.charAt(end);
			if(c1!=c2) {	// Not parlindrome
				return false;
			}
		}
		
		return true;
	}
}
