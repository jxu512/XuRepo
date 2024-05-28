/*

*/
package demos.companies.blackrock;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class AscendDescdOrder {

	public static void main(String[] args) {
		
		String s= "aaabbbcccdddxyzxyzxyz";
		String sorted = sort(s);
		System.out.println("Input:"+s);
		System.out.println("Output:"+sorted.toString());
	}
	private static String sort(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		List<Character> list = new LinkedList<>();
		for(int i=0;i<s.length();i++) list.add(s.charAt(i));
		list.sort(null);
		ListIterator<Character> it = list.listIterator();
		while(!list.isEmpty()) {
			char cur;
			char temp;
			cur='\0';
			while(it.hasNext()) {
				temp=it.next();
				if(temp!=cur) {
					sb.append(temp);
					it.remove();
					cur=temp;
				}
			}
			cur='\0';
			while(it.hasPrevious()) {
				temp=it.previous();
				if(temp!=cur) {
					sb.append(temp);
					it.remove();
					cur=temp;
				}
			}
		}
		return sb.toString();
	}
}
