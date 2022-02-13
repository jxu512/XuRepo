package demos.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

public class Java8ForEach
{
	public static void main(String[] args) 
	{
		
		//creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		//traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		System.out.print("Iterator Value::");
		while(it.hasNext())
		{
			Integer i = it.next();
			System.out.print(i+",");
		}
		System.out.println();
		// traversing with old foreach
		System.out.print("Old foreach Value::");
		for( Integer i : myList)
		{
			System.out.print(i+",");
		}
		System.out.println();
		System.out.println();
		//traversing through forEach method of Iterable with anonymous class
		System.out.print("Consumer anonymous class Value::");
		myList.forEach(new Consumer<Integer>() 
			{
				public void accept(Integer t) {
					System.out.print(t+",");
				}
	
			}
		);
		System.out.println();
		
		//traversing with Consumer interface implementation
		System.out.print("Consumer impl ");
		MyConsumer action = new MyConsumer();
		myList.forEach(action);
		System.out.println();
		
		//traversing with Consumer interface Lambda Expression
		System.out.print("Consumer impl Lambda Expression::");
		Consumer<Integer> c= i -> System.out.print(i+","); 
		myList.forEach(c);
		System.out.println();
		System.out.print("or with short notation:");
		myList.forEach(i -> System.out.print(i+","));
		System.out.println();
	}

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>
{
	public void accept(Integer t)
	{
		System.out.print(t+",");
	}

}