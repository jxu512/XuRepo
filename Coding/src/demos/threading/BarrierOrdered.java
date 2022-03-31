package demos.threading;

import java.util.concurrent.CyclicBarrier;

public class BarrierOrdered {
	
	public static void main(String[] args) {
		
		Runnable2[] r = new Runnable2[10];
		CyclicBarrier[] barrier = new CyclicBarrier[r.length];
		for(int i=0;i<r.length;i++) barrier[i]=new CyclicBarrier(2);
		for(int i=0;i<r.length;i++) {
			r[i]=new Runnable2(i,r.length, i==0?barrier[r.length-1]:barrier[i-1], barrier[i]);
			new Thread(r[i]).start();
		}
	}
}

class Runnable2 implements Runnable {

	int order=-1;
	int total=0;
	CyclicBarrier barrier1=null, barrier2=null;
	public Runnable2(int order, int total, CyclicBarrier barrier1,CyclicBarrier barrier2) {
		this.order=order;
		this.total=total;
		this.barrier1=barrier1;
		this.barrier2=barrier2;
	}
	@Override
	public void run() {

		int loops=5000;
		for(int i=0;i<loops;i++) {
		
		  	try {
		  		// Wait for left
				if(order>0||i>0) barrier1.await();
				System.out.format("%d:%3d,", order, i);
				if(order==total-1) System.out.println();
				// Notify right
				if(order<total-1 || i<loops-1) barrier2.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
