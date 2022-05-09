package demos.general;

public class IntegerSwap {

	public static void main(String[] args) {
		
		int x=0x7fffffff-1, y=Integer.MIN_VALUE;
		System.out.format("x=%x, y=%x\n", x,y);
		
		x = x+y;
		System.out.format("x=%x, y=%x\n", x,y);
		y = x-y;
		System.out.format("x=%x, y=%x\n", x,y);
		x = x-y;
		System.out.format("x=%x, y=%x\n", x,y);
		
	}
}
