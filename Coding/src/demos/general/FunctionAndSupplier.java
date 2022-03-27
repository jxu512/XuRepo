package demos.general;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class FunctionAndSupplier{
	
  public static void main(String[] argv){
	  
	// String
    Supplier<String> func1  = () ->  new String();
    System.out.println("Empty String:"+func1.get());
    
    Function<String,String> func2  = str ->  new String(str);
    System.out.println(func2.apply("java2s.com"));

    Supplier<String> func3  = String::new;
    System.out.println("Empty String:"+func3.get());
    
    Function<String,String> func4  = String::new;
    System.out.println(func4.apply("java2s.com"));
    
    // array
    IntFunction<int[]> arrayCreator1 = size ->  new int[size];
    // Creates an  int array of  five  elements
    int[] intArray1  = arrayCreator1.apply(5);
    System.out.println(Arrays.toString(intArray1));

    IntFunction<int[]> arrayCreator2 = int[]::new;
    int[] intArray2 = arrayCreator2.apply(5); 
    System.out.println(Arrays.toString(intArray2));

    IntFunction<String[]> arrayCreator3 = String[]::new;
    String[] intArray3 = arrayCreator3.apply(5); 
    System.out.println(Arrays.toString(intArray3));
  }
}