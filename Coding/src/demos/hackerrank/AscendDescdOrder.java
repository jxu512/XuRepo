package demos.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AscendDescdOrder {

	public static void main(String[] args) {
		
		String s= "aaabbbcccddxyzz";
		String sorted = sort(s);
		System.out.println("Input:"+s);
		System.out.println("Input:"+sorted.toString());
	}
	private static String sort(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		List<Character> list = new LinkedList<Character>();
		for(int i=0;i<arr.length;i++) list.add(arr[i]);
		
		while(true) {
			List<Character> temp=new ArrayList<Character>();
			Iterator<Character> it = list.iterator();
			char c = '\0';
			while(it.hasNext()) {
				char c1 = it.next();
				if(c1!=c) {
					sb.append(c1);
					c=c1;
					temp.add((Character)c1);
				}
			}
			for(Character ch:temp) ((Deque<Character>) list).removeFirstOccurrence(ch);
			if(list.isEmpty()) break;
			it = ((Deque<Character>)list).descendingIterator();
			c='\0';
			temp=new ArrayList<Character>();
			while(it.hasNext()) {
				char c1 = it.next();
				if(c1!=c) {
					sb.append(c1);
					c=c1;
					temp.add((Character)c1);
				}
			}
			for(Character ch:temp) ((Deque<Character>) list).removeFirstOccurrence(ch);
			if(list.isEmpty()) break;
		}
		return sb.toString();
	}
}
