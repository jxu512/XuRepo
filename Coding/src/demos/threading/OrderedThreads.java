package demos.threading;

public class OrderedThreads {
	
	public static void main(String[] args) {
		
		MyRunnable[] r = new MyRunnable[10];
		VolatileFlag f = new VolatileFlag();
		for(int i=0;i<r.length;i++) {
			r[i]=new MyRunnable(i,r.length, f);

			new Thread(r[i]).start();			
		}
	}
}

class MyRunnable implements Runnable {

	int order=-1;
	int total=0;
	VolatileFlag f=null;
	public MyRunnable(int order, int total, VolatileFlag f) {
		this.order=order;
		this.total=total;
		this.f=f;
	}
	@Override
	public void run() {
	  Thread.currentThread().setName(String.valueOf(order));
	  for(int i=0;i<1000;i++) {
		
			while(f.flag!=order)
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			System.out.format("%d:%3d,", order, i);
			if(order==total-1) System.out.println();
			f.flag=(order+1)%total;
		}
	}
	
}

class VolatileFlag {
	// Initialize to 1st thread
	volatile int flag=0;
}