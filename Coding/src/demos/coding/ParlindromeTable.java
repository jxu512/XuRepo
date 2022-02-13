package demos.coding;

public class ParlindromeTable {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String input = args[0];
		
		ParlindromeTable p = new ParlindromeTable();
		System.out.println("Input: "+args[0]+":"+args[0].length());
		System.out.println(p.search(args[0]));
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String search(String str) {
		String parlindrome = null;
		int len = str.length();
		byte[][] table = new byte[len][len]; 
		
		// Single char is parlindromic
		for(int i=0;i<len;i++) table[i][i]=1;
		// Two consective same char is parlindromic
		printTable(table);
		for(int i=0;i<len-1;i++) {
			if (str.charAt(i)==str.charAt(i+1)) table[i][i+1]=1;
		}
		printTable(table);
		// Three chars with same char at begin/end is parlindromic
		for(int i=0;i<len-2;i++) {
			if (str.charAt(i)==str.charAt(i+2)) table[i][i+2]=1;
		}
		printTable(table);

		// Substrings longer than 3 chars
		for(int cur_len=4;cur_len<=len;cur_len++) {		// current substring of length l
			for(int i=0;i<=len-cur_len;i++)	{			// checking (i, i+cur_len-1)
				int j=i+cur_len-1;
				if (table[i+1][j-1]==1 && str.charAt(i)==str.charAt(j)) table[i][j] = 1;
			}
		}
		printTable(table);

		return parlindrome;
	}
	/**
	 * 
	 * @return
	 */
	private void printTable(byte[][] t) {
		for(int i=0;i<t.length;i++) {
			for (int j=0;j<t.length;j++) {
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
