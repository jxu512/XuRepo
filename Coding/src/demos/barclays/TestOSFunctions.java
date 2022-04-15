package demos.barclays;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
public class TestOSFunctions {

	static BlockingQueue<FutureTask> queue = new ArrayBlockingQueue<FutureTask>(10);

	public static void main(String[] args) {
		
		// Test thread which call TestOSFunctions.getOSValue()
		int numOfTestRun = 10;
		new Thread() {
			public void run() {
				int count=0;
				for(int i=0;i<numOfTestRun;i++) {
					String s = TestOSFunctions.getOSValue(count++);
					System.out.println("Got OSValue:"+s);
				}
			}
		}.start();
		
		// main thread responsible for calling native methods
		TestOSFunctions test = new TestOSFunctions();
		int count=0;
		while(count++<numOfTestRun) {
			FutureTask f;
			try {
					f = queue.take();
					f.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String getOSValue (int a) {
		OSGetValue getFunc = new OSGetValue(a);
		FutureTask<String> task = new FutureTask<>(getFunc);
		queue.add(task);
		try {
			return task.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String setOSValue (int c, String d) {
		
		OSSetValue setFunc = new OSSetValue(c,d);
		FutureTask<String> task = new FutureTask<>(setFunc);
		try {
			return task.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

/*
 * Wrapper callable
 */
class OSGetValue implements Callable<String> {

	int num;
	public OSGetValue(int num) {
		this.num=num;
	}
	@Override
	public String call() throws Exception {
		return OSFunctions.getOSValue(num);		
	}
}
/*
 * Wrapper callable
 */
class OSSetValue implements Callable<String> {

		int num;
		String value;
		public OSSetValue(int num, String val) {
			this.num=num;
			value=val;
		}
		@Override
		public String call() throws Exception {
			OSFunctions.setOSValue(num, value);
			return "OK";
		}
}
