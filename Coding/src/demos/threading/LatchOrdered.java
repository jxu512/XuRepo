package demos.threading;

import java.util.concurrent.CountDownLatch;

public class LatchOrdered {
	
	public static void main(String[] args) {
		
		Runnable3[] r = new Runnable3[20];
		CountDownLatch[] latch = new CountDownLatch[r.length];
		for(int i=0;i<r.length;i++) latch[i]=new CountDownLatch(1);
		for(int i=0;i<r.length;i++) {
			r[i]=new Runnable3(i,r.length, i==0?latch[r.length-1]:latch[i-1], latch[i]);
			new Thread(r[i]).start();
		}
	}
}

class Runnable3 implements Runnable {

	int order=-1;
	int total=0;
	CountDownLatch latch1=null, latch2=null;
	public Runnable3(int order, int total, CountDownLatch latch1,CountDownLatch latch2) {
		this.order=order;
		this.total=total;
		this.latch1=latch1;
		this.latch2=latch2;
	}
	@Override
	public void run() {

		  	try {
		  		// Wait for left
				if(order>0) latch1.await();
				System.out.format("%d,", order);
				if(order==total-1) System.out.println();
				// Notify right
				if(order<total-1) latch2.countDown();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
}
