package demos.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
		s.streamIsLazyAndNotReusable();
		s.parallel();
		//s.streamOf();

		s.printOneLine();
	}

	private void printOneLine() {
		List<List<String>> fruits = new ArrayList<>();
		fruits.add(List.of("Apple", "Orange"));
		fruits.add(List.of("Kiwi", "Banana"));
		fruits.add(List.of("Pear", "Blueberry"));

		fruits.stream().forEach(list->list.forEach(f->System.out.print(f+",")));
		System.out.println();
		System.out.println(fruits.stream().reduce("", (a,b)->a+String.join(",",b)+";", (x,y)->""));
		List<String> list = fruits.stream().reduce(new ArrayList<>(), (a,b)->{a.addAll(b);return a;});
		list.forEach(fruit->System.out.print(fruit+","));

		Optional<List<String>> optional =
				fruits.stream().reduce((a,b)->{
		    		List<String> li = new ArrayList<>();
					li.addAll(a);
					li.addAll(b);
					return li;
				});
		System.out.println();
		optional.get().forEach(fruit->System.out.print(fruit+","));
	}
	private void filterMapAggregate() {
		int sum = entries.stream()
				.filter(e->e.id%2==1)
				.mapToInt(e->e.id)
				.sum();
		System.out.format("Fileter/map/Sum is %d\n", sum);
	}
	private void parallel() {
		
		int sum=0;
		long t1, t2;
		int len = 1_000;
		Integer[] array = new Integer[len];
		Arrays.fill(array, 1);
		List<Integer> list = Arrays.asList(array);
		//for(int i=0;i<len;i++) list.add(i);
		IntStream intSt;
		
		System.out.println("Loop vs Sequential vs Parallel");
		
		intSt = list.stream().mapToInt(Integer::intValue);
		t1 = System.currentTimeMillis();
		for(int num:list) sum += num;
		t2 = System.currentTimeMillis();
		System.out.format("Loop time: %d\n",(t2-t1));

		intSt = list.stream().mapToInt(Integer::intValue);
		t1 = System.currentTimeMillis();
		sum = intSt.sum();
		t2 = System.currentTimeMillis();
		System.out.format("Sequential time: %d\n",(t2-t1));

		intSt = list.parallelStream().mapToInt(Integer::intValue);
		t1 = System.currentTimeMillis();
		sum = intSt.sum();
		t2 = System.currentTimeMillis();
		System.out.format("Parallel time: %d\n",(t2-t1));

	}
	private void streamIsLazyAndNotReusable() {
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<5;i++) list.add(i);
		Stream<Integer> st = list.stream();
		list.add(5);	// New elements will be includd in stream
		int sum = st.mapToInt(Integer::intValue).sum();
		System.out.format("List: %s\n",list);
		System.out.format("Sum of list: %d\n",sum);
		try { 
			sum = st.mapToInt(Integer::intValue).sum();	// Run time rror: stream can't be reused 
		}
		catch(Exception e) { System.out.println("Stream is not reusable.\n\n"); }
	}
	private void streamOf() {
		
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
	private void groupBy() {
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
	private void partitionBy() {
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