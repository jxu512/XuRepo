package demos;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class GC_Test 
{
	public static void main(String[] args)
	{
		LocalArray[] array = new LocalArray[460];
		
		while(true)
		{
			// Allocation
			for(int i=0;i<array.length;i++)
			{
				array[i] = new LocalArray();
				System.out.println("Allocated one LocalAray, round  " + i +" at " + Calendar.getInstance().getTime().toString());
				try {	TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e)	{	e.printStackTrace();	}
			}
			// Deallocation
			for(int i=0;i<array.length;i++)
			{
				array[i] = null;
				System.out.println("Deallocated one LocalAray, round  " + i +" at " + Calendar.getInstance().getTime().toString());
				try {	TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e)	{	e.printStackTrace();	}
			}
			
			System.out.println("Press e to exit...");
			try {
				int k = System.in.read();
				if(k=='e') System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class LocalArray
{
	int len = 1000;
	String[][] arr = new String[len][len];
	
	public LocalArray()
	{
		for(int i=0;i<len;i++)
			for(int j=0;j<len;j++)
			arr[i][j] = "This is a test string.This is a test string.This is a test string..This is a test string.";
		
	}
}