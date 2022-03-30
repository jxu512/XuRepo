package demos.threading;

import java.util.concurrent.Phaser;

public class PhaserTest {
	
	public static void main(String[] args) {
		
		Runnable5[] r = new Runnable5[10];
		// onAdvance() determines if Phaser will move to next phase, 
		// default returns true which means only one phase, which means call of arriveAndAwaitAdvance() returns right away
		final Phaser phaser = new Phaser() {
		     protected boolean onAdvance(int phase, int registeredParties) {
		    	 if(phase>0) System.out.println("--phase "+phase);
		       return false;
		     }
		   };
		   phaser.register();
		   for(int i=0;i<r.length;i++) {
			r[i]=new Runnable5(i,r.length,phaser);
			new Thread(r[i]).start();
		}
		// Allow threads to start
		phaser.arriveAndDeregister();
	}
}

class Runnable5 implements Runnable {

	int order=-1;
	int total=0;
	
	Phaser phaser=null;
	public Runnable5(int order, int total, Phaser phaser) {
		this.order=order;
		this.total=total;
		this.phaser=phaser;
		phaser.register();		// Registration should not be from running thread
	}
	@Override
	public void run() {
		
		// phaser.register(); // Registration must not from running thread, because current phase may be going on
		int loops=10;
		  	try {
		  		for(int i=0;i<loops;i++) {
			  		phaser.arriveAndAwaitAdvance();
					System.out.format("%d,", order);
		  		}
		  		phaser.arriveAndDeregister();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
}
