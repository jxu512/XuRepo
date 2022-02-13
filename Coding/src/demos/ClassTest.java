package demos;

public class ClassTest {

		public static void main(String[] args) {
			int i = 10;
			double[] dArray = {10.0,20.00};
			String s= "abcd";
			int[] iArray = {1,2,3,4,5};
			int[] iArray1 = new int[10];
			ClassTest c1 = new ClassTest();
			ClassTest c2 = new ClassTest();
			
			System.out.println("double[] dArray:"+dArray.getClass().getName());
			System.out.println("int[] iArray:"+iArray.getClass().getName()+", is aray:"+iArray.getClass().isArray());
			System.out.println("int[].class:"+int[].class);
			System.out.println("ClassTest.class:"+System.identityHashCode(ClassTest.class));
			System.out.println("ClassTest.c1:"+System.identityHashCode(c1.getClass()));
			System.out.println("ClassTest.c2:"+System.identityHashCode(c2.getClass()));
			System.out.println("abcd:"+s.getClass().getName());
			System.out.println("int:"+int.class.isPrimitive());
		}
}
