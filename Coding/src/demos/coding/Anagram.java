package demos.coding;

public class Anagram {

	
	public static void main(String[] args) {
		
		Anagram anagram = new Anagram();
		boolean res = anagram.isAnagram(args[0], args[1]);
		System.out.println(args[0]+" and "+args[1]+" are"+(res?"":"not")+" anagram");
	}
	/**
	 * 
	 * @param s: lower case string
	 * @param t: lower case string
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int a[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
			a[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
