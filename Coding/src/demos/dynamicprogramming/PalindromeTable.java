package demos.dynamicprogramming;

public class PalindromeTable {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String input = args[0];
		
		PalindromeTable p = new PalindromeTable();
		String parlindrome=p.search(args[0]);
		System.out.println("Input: "+args[0]+":"+args[0].length());
		System.out.println("Longest parlindrome: "+parlindrome);
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String search(String str) {
		String parlindrome = null;
		int len = str.length();
		/*
			Find all palindrome in a string
			Dynamic programming.
			len: string length
			table[len + 1][len], where row index is the length of potential palindrome, (row 0 is not used)
				col is start position in sring
		 */
		byte[][] table = new byte[len+1][len];
		
		// Single char is parlindromic
		for(int i=1;i<len;i++) table[1][i]=1;
		// Two consective same char is parlindromic
		//printTable(table);
		for(int i=0;i<len-1;i++) {
			if (str.charAt(i)==str.charAt(i+1)) table[2][i]=1;
		}
		//printTable(table);
		// Three chars with same char at begin/end is parlindromic
		for(int i=0;i<len-2;i++) {
			if (str.charAt(i)==str.charAt(i+2)) table[3][i+2]=1;
		}
		//printTable(table);

		// Substrings longer than 3 chars
		for(int cur_len=4;cur_len<=len;cur_len++) {		// Substring of length cur_len
			for(int i=0;i<=len-cur_len;i++)	{			// i: start position in string
				// For (cur_len, i) to be palindrome, (cur_len-2,i+1) must be palindrome and (i)=(j+)
				if (table[cur_len-2][i+1]==1 && str.charAt(i)==str.charAt(cur_len+i-1)) {
					table[cur_len][i] = 1;
				}
			}
		}
		printTable(table);

		// Return the longest parlindrome
		int start=0,length=0,longest=1;
		boolean found = false;
		for (int cur_len=len;cur_len>0 && !found;cur_len--) {
			for (int p=0;p<len;p++) {
				if (table[cur_len][p]==1) {
					start = p;
					length=cur_len;
					found = true;
					break;
				}
			}
		}
		
		return str.substring(start, start+length);
	}
	/**
	 * 
	 * @return
	 */
	private void printTable(byte[][] t) {
		int rows = t.length;
		int cols = t.length - 1;
		for(int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
