package demos.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

public final class Iterators {
	ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) {
		
		Iterators its = new Iterators();
		its.init();
		its.testIterator();
		its.testListIterator();
		its.testSpliterator();
	}
	
	private void testIterator() {
		// Once an iterator, if the collection is structurely modified, iterator will throw ConcurrentModificationException
		System.out.println("Iterator can't be used if collection is structurely modified");
		Iterator<String> it = list.iterator();
		//list.add("b");
		//it.next();it.remove();		// Iterator allows removal of last returned element
		
		System.out.println("Two implicit iterators: (clean)");
		List<String> ul = Collections.unmodifiableList(list);
		for(String s1:ul) {
			for(String s2:ul) System.out.print("("+s1+","+s2+")");
			// list.remove(0);		// Can't remove due to implicit iterator
			System.out.println();
		}
		// or
		System.out.println("Two explicit iterators: (tricky)");
		Iterator<String> it1 = list.iterator();
		while(it1.hasNext()) {
			String s1=it1.next();
			// list.add("X");	//Iterator can't be used if collection is structurely modified
			Iterator<String> it2 = list.iterator();
			while(it2.hasNext()) System.out.print("("+s1+","+it2.next()+")");
			System.out.println();
		}
		System.out.println();
	}

	private void testListIterator() {
		
		ListIterator<String> lit = list.listIterator();
		System.out.print("ListIterator forward: ");
		while(lit.hasNext()) System.out.print(lit.next());
		System.out.println();		
		System.out.print("ListIterator backward: ");
		while(lit.hasPrevious()) System.out.print(lit.previous());
		System.out.println();
		System.out.println();
	}
	private void testSpliterator() {
		 
		Spliterator<String> spliterator1 = list.spliterator();
		Spliterator<String> spliterator2 = spliterator1.trySplit();
		 
		System.out.print("Spliterator 1: ");
		spliterator1.forEachRemaining((s)->System.out.print(s));
		System.out.println();
		System.out.print("Spliterator 2: ");
		while(spliterator2.tryAdvance(System.out::print));
		
		System.out.println();
	}
	private void init() {

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");

	}
}
