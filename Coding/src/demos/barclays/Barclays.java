package demos.barclays;

public class Barclays {
	
	public static void main(String[] args) {
		
		Barclays b = new Barclays();
		b.numOfOnes(127);
		String s="a";
		int n=10000000;
		b.repeatString(s, n);
		b.repeatString_v1(s, n);
	}
	public int numOfOnes(int a) {
	
		int total = 0;
		int temp = 1;
		for(int i=0;i<32;i++){
		    int r = a & temp;
		    if(r!=0) total++;
		    temp = temp<<1;
		}
		System.out.format("There are %d ones in %d\n", total, a);
		return total;
	}

	public String repeatString(String s, int n) {

		StringBuilder sb = new StringBuilder();
		long t1=System.currentTimeMillis();
		for(int i=0;i<n;i++) {
		    sb.append(s);
		}
		long t2=System.currentTimeMillis();
		System.out.println("Time: "+((t2-t1))+", sb size:"+sb.length());
		//System.out.format("%s repeated %d times: %s\n", s, n, sb.toString());
		return sb.toString();
	}

	public String repeatString_v1(String s, int n) {
	
		StringBuilder sb = new StringBuilder();
		int times=n;
		StringBuilder sb1=new StringBuilder(s);
		long t1=System.currentTimeMillis();
		int loops=0;
		while (n>0) {
		    if(n%2==1) sb.append(sb1.toString());
		    sb1.append(sb1.toString());
		    n=n>>1;
		    System.out.println("Loops:"+(++loops)+", sb1 size:"+sb1.length());		}
		long t2=System.currentTimeMillis();
		System.out.println("Time: "+((t2-t1))+", sb size:"+sb.length());
		//System.out.format("%s repeated %d times: %s\n", s, times, sb.toString());
		return sb.toString();
	}

}

