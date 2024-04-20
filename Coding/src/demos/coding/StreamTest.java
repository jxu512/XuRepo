package demos.coding;

import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    
	IntStream intStream;
	
    public StreamTest() {
        // do intialization if necessary
    	intStream = IntStream.builder()
    			.add(5)
    			.add(9)
    			.add(33)
    			.add(5)
    			.add(9)
    			.add(33)
    			.add(25)
    			.build();
    	//intStream.forEach(num->System.out.println(num));
    	//System.out.println();
    }

	/**
	* Adds integer num to a stream of integers.
	*/
    public void add(int num) {
        // write your code here
    	intStream = IntStream.concat(intStream, IntStream.of(num));
    	//newStream.forEach(n->System.out.println(n));
    	//System.out.println();
    }

	/**
	*  Returns the first unique integer in the stream if found else return null.
	*/
    public Integer getFirstUnique() {
        // write your code here
    	int res = 0;
		    	
    	return 0;
    }
    
    public static void main(String[] ags) {
    	StreamTest test = new StreamTest();
    	test.add(88);
    	test.getFirstUnique();
    }
}