package demos.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicStream {

	ArrayList<Entry> entries = null;
	
	public static void main(String[] args) {
		BasicStream s = new BasicStream();
		s.init();
		
		s.filterMapAggregate();
		s.groupBy();
		s.streamOf();
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
}
	private void init() {
		entries = new ArrayList<>();
		int num=100;
		for(int i=0;i<num;i++) {
			entries.add(new Entry(i,String.valueOf(i)));
		}
	}
}

class Entry{
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
}