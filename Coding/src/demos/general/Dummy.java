package demos.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Dummy {
	
	public static void main(String[] args) {
		
		Integer n1=Integer.valueOf(5);
		Integer n2=Integer.valueOf("8");
		Integer n3=n1+n2;
		
		Dummy dummy=new Dummy();
		
		List<String> list=new ArrayList<>();
		list.add("a");
		Iterator<String> it = list.iterator();
		list.add("b");
		list.add("c");
		it.next();
		it.remove();
		List<String> ul = Collections.unmodifiableList(list);
		for(String s1:ul) {
			for(String s2:ul) System.out.print("("+s1+","+s2+")");
			System.out.println();
		}
	}

}
