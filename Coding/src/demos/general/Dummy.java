package demos.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public final class Dummy {
	
	public static void main(String[] args) {

		int a = -2;
		System.out.format("%x:",a);
		int b=a>>1;
		System.out.format("%x:",b);		
		b=a>>1;
		System.out.format("%x:",b);		
		b=a>>1;
		b=a<<1;
		int c=a>>>1;
		
		int x=0x7fffffff;
		int y=x<<1;
		
		String s="abcde";
		s.repeat(5);
		s.replace("a","b");
		
		Object o = new Object();
		synchronized(o) {
		try {
			o.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}
