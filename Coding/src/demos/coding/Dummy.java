package demos.coding;

import java.util.HashSet;

public final class Dummy {
	volatile int a=0;
	volatile Integer i;
	volatile String s="";
	
	private final HashSet<String> set = new HashSet<>();
	private final int x;
	public static void main(String[] args) {
		
		String s = "abcd";
		String s1=s.substring(0,0);
		String s2=s.substring(s.length());
		
		Integer n1=Integer.valueOf(5);
		Integer n2=Integer.valueOf("8");
		Integer n3=n1+n2;
		
		Dummy dummy=new Dummy();
		dummy.init();
	}
	private Dummy() {
		set.add("a");
		set.add("b");
		x=9;
	}
	private void init() {
		set.add("c");
		set.add("d");
	}
}
