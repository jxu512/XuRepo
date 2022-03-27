package demos.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortingObjects {

	ArrayList<MyEntry> entries = null;
	
	public static void main(String[] args) {
		SortingObjects s = new SortingObjects();
		MyEntry[] entries = new MyEntry[10];
		for(int i=0;i<entries.length;i++) entries[i]=new MyEntry(i,String.valueOf(i));
		// Below will fail without MyEntry implementing Comparable
		Arrays.sort(entries);
		
		// Always OK
		Set<MyEntry> set = new HashSet<MyEntry>();
		for(int i=0;i<entries.length;i++) set.add(new MyEntry(i,String.valueOf(i)));
		// Require MyEntry implementing Comparable
		Set<MyEntry> set1 = new TreeSet<MyEntry>();
		for(int i=0;i<entries.length;i++) set1.add(new MyEntry(i,String.valueOf(i)));
	}

}

class MyEntry implements Comparable<MyEntry> 	// Sorting related operations fail with out implementing Comparable because there is no default Comparable implementation
{
	int id;
	String type;
	String value;
	
	public MyEntry(int id, String value) {
		this.id=id;
		this.value=value;
		this.type=id%2==0?"Even":"Odd";
	}
	public String getType() {
		return type;
	}
	public String toString() {
		return id+"/"+type;
	}
	@Override
	public int compareTo(MyEntry o) {
		return id-o.id;
	}

}