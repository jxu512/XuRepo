package demos.companies.jpm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		Test.swap();;
		Test.reverse();
		Integer[] array = { 2,1,4,6,5 };
		Test.sort(array);
	}
	
	public static void sort(Integer[] array) {
		System.out.println(array);

		// Arrays.sort
		Arrays.sort(array);

		List<Integer> list = Arrays.asList(array);
		System.out.println(list);
		// Stream
		List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
		List<Integer> sorted1 = list.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		List<Integer> sorted2 = list.stream().sorted().collect(Collectors.toCollection(LinkedList::new));
		System.out.println(sorted);
		
	}
	
	public static void reverse() {
		
		String s = "abcxyz";
		System.out.println(s);
		char[] ch = s.toCharArray();
		int len = s.length();
		for(int i=0;i<len/2;i++) {
			char tmp = ch[i];
			ch[i] = ch[len-1-i];
			ch[len-1-i] = tmp;
		}
		
		String reversed = new String(ch);
		System.out.println(reversed);
	}
	
	public static void swap() {
		int a=10;
		int b=5;
		
		System.out.format("a:%d, b:%d => ", a, b);

		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.format("a:%d, b:%d\n", a, b);
	}
	
	
}
