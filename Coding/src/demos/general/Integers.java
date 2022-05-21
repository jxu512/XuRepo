package demos.general;

public class Integers {

	public static void main(String[] args) {
		swap();
		twoscompliment();
		types();
	}
	
	public static void swap( ) {
		int x=0x7fffffff-1, y=Integer.MIN_VALUE;
		System.out.format("x=%x, y=%x\n", x,y);
		
		x = x+y;
		y = x-y;
		x = x-y;
		System.out.format("x=%x, y=%x\n\n", x,y);
	}
	/*
	 Java uses two's compliment to represent integers. Three digit example
	 
	 000	0
	 001	1
	 010	2
	 011	3	// Positive Max
	 100	-4	// Negative Min
	 101	-3
	 110	-2
	 111	-1
	*/
	public static void twoscompliment() {
		
		System.out.format("MAX: %d, ", Integer.MAX_VALUE);
		System.out.format("negative of MAX: %d\n", -Integer.MAX_VALUE);
		System.out.format("MIN: %d, ", Integer.MIN_VALUE);
		System.out.format("negative of MIN: %d\n\n", -Integer.MIN_VALUE);
	}
	public static void types() {
		byte b1=8;
		byte b2=-2;
		byte b3=(byte)(b1+b2);	// Compile error without conversion, because Java convert byte to integer for operation
		System.out.format("%d+(%d)=%d\n",b1,b2,b3);
	}
}
