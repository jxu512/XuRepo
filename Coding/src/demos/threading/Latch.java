package demos.threading;

import java.util.concurrent.CountDownLatch;

public class Latch {
	
	public static void main(String[] args) {
		
		Runnable4[] r = new Runnable4[20];
		CountDownLatch latch = new CountDownLatch(1);
		for(int i=0;i<r.length;i++) {
			r[i]=new Runnable4(i,r.length,latch);
			new Thread(r[i]).start();
		}
		latch.countDown();
	}
}

class Runnable4 implements Runnable {

	int order=-1;
	int total=0;
	CountDownLatch latch=null;
	public Runnable4(int order, int total, CountDownLatch latch) {
		this.order=order;
		this.total=total;
		this.latch=latch;
	}
	@Override
	public void run() {

		  	try {
				latch.await();		// First await blocks
				latch.await();		// Subsequent await returns right away, i.e., CountDownLatch can't be reused
				latch.await();
				System.out.format("%d,", order);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
}
