package demos.coding;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CandyCrusher {

	List<Character> list = null;
	
	public CandyCrusher(String candyStr) {

		initList(candyStr);
	}

	private void initList(String candyStr) {

		list = new LinkedList<Character>();
		
		if(candyStr==null||candyStr.isEmpty()) return;
		int len = candyStr.length();
		for(int i=0;i<len;i++) list.add(candyStr.charAt(i));
	}

	private void crush() {

		ListIterator<Character> iterator = list.listIterator();

		Character current=null;
		Character next = null;
		int count;
		current = iterator.next();
		System.out.println(list);
		while(current!=null) {
			count=1;
			next = null;
			while (iterator.hasNext()) {
					next = iterator.next();
					if(current==next) count++;
						else break;
				}
			// Crush current candies
			//if(cursorMoved) 
			if (count>=3) {
				if(iterator.hasPrevious() && current!=next) iterator.previous(); 	// Move cursor to last candy to be crushed
				for(int i=0;i<count;i++) {
					Character toRemove = iterator.previous();
					iterator.remove();
				}
				System.out.println(list);
				// Move back two positions
				if(iterator.hasPrevious()) iterator.previous();
				if(iterator.hasPrevious()) iterator.previous();
				if(iterator.hasNext()) next = iterator.next();
					else next=null;
			}
			// Next
			current = next;

		}
	}
	public static void main(String[] args) {
		CandyCrusher candy = new CandyCrusher(args[0]);
		
		candy.crush();
	}

}
