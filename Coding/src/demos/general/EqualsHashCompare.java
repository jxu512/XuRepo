package demos.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EqualsHashCompare {
	
	public static void main(String[] args) {
		EqualsHashCompare ehc = new EqualsHashCompare();
		
		ehc.test1();
		ehc.test2();
	}
	public void test1() {
		Set<Entry1> set1 = new HashSet<>();
		Set<Entry1> set2 = new TreeSet<>();
		Entry1 e1 = new Entry1(1,"a");
		Entry1 e2 = new Entry1(1,"a");
		
		// HashSet
		set1.add(e1);	//OK
		set1.add(e2);	//OK but not desired, because both e1 and e2 are in set
		// TreeSet
		try {
		set2.add(e1);	// Error because TreeSet requires sort/ comparable
		}
		catch(Exception e) { e.printStackTrace();}
	}
	public void test2() {
		Set<Entry2> set1 = new HashSet<>();
		Set<Entry2> set2 = new TreeSet<>();
		Entry2 e1 = new Entry2(1,"a");
		Entry2 e2 = new Entry2(1,"a");
		Entry2 e3 = new Entry2(1,"b");
		Entry2 e4 = new Entry2(2,"b");
		
		// HashSet
		set1.add(e1);	//OK
		set1.add(e2);	//OK but e2 ignored in set because e2==e1 according to equeals function
		set1.add(e3);	//OK and e3 added to set
		set1.add(e4);	//OK and e4 added to set
		// TreeSet
		set2.add(e1);	// OK because Entry2 implements Comparable
		set2.add(e2);	// OK but e2 ignored in set because e2==e1 according to equeals function
		set2.add(e3);	//OK and e3 added to set. Note: TreeSet uses compareTo instead of equals
						//if comparesTo compares only ID, e3 will be ignored since it would be equal to e1/e2 
						//according to compareTo
		set2.add(e4);	//OK and e4 added to set
	}

}

class Entry1{
	int id;
	String name;
	
	public Entry1(int id, String name) {
		this.id=id;
		this.name=name;}
}
class Entry2 implements Comparable<Entry2> {
	int id;
	String name;
	
	public Entry2(int id, String name) {
		this.id=id;
		this.name=name;}

	@Override
	public boolean equals(Object o) {
		if(o==null || ! (o instanceof Entry2)) return false;
		Entry2 e=(Entry2)o;
		return id==e.id && name.equalsIgnoreCase(e.name);
	}
	@Override
	public int compareTo(Entry2 o) {
		
		if(id==o.id) return name.compareToIgnoreCase(o.name);
		else 
			return id-o.id;
	}
	@Override
	public int hashCode() {
		return Integer.valueOf(id).hashCode() + name.hashCode();
	}
}