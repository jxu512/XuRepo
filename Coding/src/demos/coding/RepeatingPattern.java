package demos.coding;

public class RepeatingPattern {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RepeatingPattern p = new RepeatingPattern();
		System.out.println("Input: "+args[0]+":"+args[0].length());
		System.out.println("Pattern:"+p.search(args[0]));

	}
	
	public String search(String s) {
		String p = null;
		boolean found = false;
		
		// Possible repeating pattern of length i
		for(int i=s.length()-2;i>1;i--) {
			
			// Check substring of length i starting at index1
			for(int index1=0; index1<s.length()-i;index1++) {
				String current_pattern = s.substring(index1, index1+i);
				p = current_pattern;
				String remaining = s.substring(index1+1);
				// Check if it repeats
				found = remaining.indexOf(current_pattern) > 0;
				if (found) break;
			}
			if (found) break;
		}
		
		return p;
	}
}
