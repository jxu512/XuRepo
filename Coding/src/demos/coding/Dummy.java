package demos.coding;

public class Dummy {

	public static void main(String[] args) {
		
		String s = "5[abc]";
		String[] str = s.split("[\\[|\\]]");
		System.out.println(str);
	}
}
