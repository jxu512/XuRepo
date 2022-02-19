package demos.coding;

class CountAndSay {
	
    public String countAndSay(int n) {
    	if (n==1) {
        	System.out.println("1");
        	return "1";
        }
        return convert(countAndSay(n-1));
    }

	private String convert(String str) {
		
		int count;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length();) {
			count = peekAndCount(i, str);
			sb.append(count).append(str.charAt(i));
			i += count;
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	private int peekAndCount(int index, String str) {
		if(str==null||str.length()==0) return 0;
		int count=0;
		for(int i=index;i<str.length();i++) {
			if(str.charAt(i)==str.charAt(index)) count++;
			else break;
		}
		return count;
	}
	/**
	 * 
	 * @param n
	 */
	private void CountAndSayIterative(int n) {
		
		String input = "1";
		StringBuilder sb = new StringBuilder();
		System.out.println(input);
		int count;
		for(int i=2;i<=n;i++) {
			
			for(int j=0;j<input.length();) {
				int k=j+1;
				count=1;
				while(k<input.length() && input.charAt(j)==input.charAt(k++)) count++;
				//count = peekAndCount(j, input);
				sb.append(count).append(input.charAt(j));
				j += count;
			}
		input=sb.toString();
		sb.setLength(0);
		System.out.println(input);
		}
	}
	
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		CountAndSay say = new CountAndSay();
    	System.out.println("Recursive way:");
		say.countAndSay(num);
    	System.out.println("Iterative way:");
		say.CountAndSayIterative(num);
	}
}