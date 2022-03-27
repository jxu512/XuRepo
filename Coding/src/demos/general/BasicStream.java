package demos.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStream {

	ArrayList<Entry> entries = null;
	
	public static void main(String[] args) {
		BasicStream s = new BasicStream();
		s.init();
		
		s.filterMapAggregate();
		s.groupBy();
		s.partitionBy();
		s.toCollectionListMapAndSet();
		s.toMap();
		//s.streamOf();
	}
	public void filterMapAggregate() {
		int sum = entries.stream()
				.filter(e->e.id%2==1)
				.mapToInt(e->e.id)
				.sum();
		System.out.format("Fileter/map/Sum is %d\n", sum);
	}
	public void streamOf() {
		
		try {
			int sum = 
			Stream.of(new BufferedReader(new InputStreamReader(System.in)).readLine().split("\\s+"))
			.mapToInt(s->Integer.parseInt(s))		//.mapToInt(Integer::parseInt)
			.reduce(0, (sub, ele)->sub+ele)			//.sum()
			;
			
			System.out.format("Sum from input(sum/reduce):%d ",sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void groupBy() {
		Map<String, List<Entry>> map = 
			entries.stream().collect(Collectors.groupingBy((e)->e.type));
		System.out.println("GroupingBy to map:");
		map.forEach((k,v)->System.out.println(k+":"+v));

		Map<String, Long> map1 = 
			entries.stream().collect(Collectors.groupingBy(/*(e)->e.type*/ Entry::getType, Collectors.counting()));
		System.out.println("GroupingBy to map with count:");
		map1.forEach((k,v)->System.out.println(k+":"+v));

		System.out.println("");
	}
	public void partitionBy() {
	Map<Boolean, List<Entry>> map = 
			entries.stream().collect(Collectors.partitioningBy((e)->e.type.equals("Even")));
		System.out.println("PartitioningBy to map: "+map.getClass());
		map.forEach((k,v)->System.out.println(k+":"+v));

		Map<Boolean, Long> map2 = 
			entries.stream().collect(Collectors.partitioningBy((e)->e.type.equals("Even"), Collectors.counting()));
		System.out.println("PartitioningBy to map w count: "+map2.getClass());
		map2.forEach((k,v)->System.out.println(k+":"+v));
		System.out.println("");
	}
	private void toCollectionListMapAndSet() {
		
		List<Entry> list = entries.stream().filter(e->e.type.equals("Even")).collect(Collectors.toList());
		System.out.format("toList: %s\n", list.getClass());
		
		Supplier<LinkedList<Entry>> sup = LinkedList::new;	// Or
		sup = ()->new LinkedList<Entry>();		// 
		List<Entry> list1 = entries.stream().filter(e->e.type.equals("Even")).collect(Collectors.toCollection(sup));
		System.out.println("toListFromCollection: "+list1.getClass());
		
		List<Entry> list2 = list1.stream().filter(e->e.type.equals("Even")).collect(Collectors.toList());
		System.out.println("toCollection: "+list2.getClass());		

		Set<Entry> set = entries.stream().filter(e->e.type.equals("Even")).collect(Collectors.toSet());
		System.out.println("toSet: "+set.getClass());

		// Note: TreeSet won't work without Entry implementing Comparable
		Set<Entry> set1 = entries.stream().filter(e->e.type.equals("Even")).collect(Collectors.toCollection(HashSet<Entry>::new));
		System.out.println("toSetFromCollection: "+set1.getClass());
		Set<Entry> set2 = entries.stream().filter(e->e.type.equals("Even")).collect(Collectors.toCollection(TreeSet<Entry>::new));
		System.out.println("toSetFromCollection: "+set2.getClass());
		
		System.out.println("");
	}
	private void toMap() {
		
		Map<Integer, Entry> map=
			entries.stream().collect(Collectors.toMap(e->e.id, e->e));
		System.out.println("ToMap: "+map.getClass());
		
		Map<Integer, Entry> map1=
				entries.stream().collect(Collectors.toConcurrentMap(e->e.id, e->e));
			System.out.println("toConcurrentMap: "+map1.getClass());

			Map<Integer, Entry> map2=
					entries.stream().collect(Collectors.toMap(e->e.id, e->e, (e1,e2)->e1, TreeMap::new));
			System.out.println("toMapWithType: "+map2.getClass());
			System.out.println(map2);
			
		System.out.println("");
	}
	private void init() {
		entries = new ArrayList<>();
		int num=100;
		for(int i=0;i<num;i++) {
			entries.add(new Entry(i,String.valueOf(i)));
		}
	}
}

class Entry implements Comparable<Entry> {	// Sort related operations fail without implementing Comparable
	int id;
	String type;
	String value;
	
	public Entry(int id, String value) {
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
	public int compareTo(Entry o) {
		return id-o.id;
	}

}