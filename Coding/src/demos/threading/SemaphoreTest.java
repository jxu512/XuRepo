/*
 Self implement Semaphore
*/
package demos.threading;

public class SemaphoreTest {

	int limits=5;
	int used=0;
	
	public SemaphoreTest(int capacity) {
		limits = capacity;
	}
	public synchronized int available() {
		return limits-used;
	}
	public synchronized void acquire() {
		
		while(true) {
			if(used<limits) {
				used++;
				return;
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized boolean tryAcquire() {
		
			if(used<limits) {
				used++;
				return true;
			}
			else return false;
	}
	public synchronized void release() {
		
		used--;
		notifyAll();
	}
	
	public static void main(String[] args){
		SemaphoreTest s = new SemaphoreTest(5);
		
		Thread[] t = new Thread[15];
		for(int i=0;i<t.length;i++) {
			t[i] = new Thread(() -> {
				s.acquire();
				System.out.println(Thread.currentThread().getName()+" got semaphore, remaining:"+s.available());
				s.release();
				System.out.println(Thread.currentThread().getName()+" released semaphore, remaining:"+s.available());
			});
			t[i].start();
		}
	}
}
