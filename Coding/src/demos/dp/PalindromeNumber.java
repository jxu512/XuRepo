package demos.dp;

public class PalindromeNumber {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String input = args[0];
		
		PalindromeNumber p = new PalindromeNumber();
		// Use string
		System.out.println(input+" is "+(p.isPalindrome(input)?"":" not ")+ " palindrome.");
		
		// Use number
		int number = 0;
		number=Integer.valueOf(input);
		System.out.println(input+" is "+(p.isPalindrome(number)?"":" not ")+ " palindrome.");
		
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public boolean isPalindrome(String number) {
		
		if(number==null || number.length()==1 ) return true;
		
		int len = number.length();
		for(int i=0;i<len/2;i++) {
			if (number.charAt(i)!=number.charAt(len-1-i)) return false;
		}
		return true;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	private boolean isPalindrome(int number) {
		
		if(number<0) return false;
		if(number>=0 && number < 10) return true;
		if(number%10==0) return false;
		int reverted = 0;
		int remainder=0;
		int partial=number;
		while (reverted < partial) {
			remainder=partial%10;
			partial=partial/10;
			reverted = reverted*10+remainder;
		}
		return partial==reverted || partial==reverted/10;
	}
}
