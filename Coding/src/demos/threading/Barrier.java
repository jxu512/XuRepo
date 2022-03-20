package demos.threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
	
	public static void main(String[] args) {
		
		Runnable1[] r = new Runnable1[10];
		CyclicBarrier latch = new CyclicBarrier(r.length, ()->System.out.println() );
		for(int i=0;i<r.length;i++) {
			r[i]=new Runnable1(i,r.length, latch);
			new Thread(r[i]).start();
		}
	}
}

class Runnable1 implements Runnable {

	int order=-1;
	int total=0;
	CyclicBarrier latch=null;
	public Runnable1(int order, int total, CyclicBarrier latch) {
		this.order=order;
		this.total=total;
		this.latch=latch;
	}
	@Override
	public void run() {

		int l=-1;
		for(int i=0;i<1000;i++) {
		
		  	try {
				l=latch.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.format("%d:%3d,", order, i);
		}
	}
	
}
