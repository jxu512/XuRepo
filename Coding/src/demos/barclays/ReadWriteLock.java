/*
Implement ReadWriteLock, multiple reads can happen at same time if no write going on, 
and only onw write can happen at any time
*/

package demos.barclays;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteLock {

	int read=0;
	boolean write=false;
	
	public static void main(String[] args) {
		
		ReadWriteLock rw = new ReadWriteLock();
		rw.test(rw);
		
	}
	
	private void test(ReadWriteLock rw) {
		
		int num = 5;
		Thread[] threads=new Thread[num];
		int[] cnt=new int[1];
		List<String> list = new ArrayList<>();
		for(int i=0;i<num;i++) {
			threads[i]=new Thread(new MyRunnable(cnt, "T"+i, rw, list));
			threads[i].start();
		}
		for(int i=0;i<num;i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public synchronized void acquireReadLock() {

		while(true) {
			if(!write) {
				read+=1;
				return;
			}
			else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public synchronized void releaseReadLock() {

				read-=1;
				this.notifyAll();
	}
	public synchronized void acquireWriteLock() {
		while(true) {
			if(read==0 && !write) {
				write=true;
				return;
			}
			else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public synchronized void releaseWriteLock() {

		write=false;
		this.notifyAll();
	}
	public synchronized int getReadLockCnt() {
		return read;
	}
	public synchronized boolean getWriteLock() {
		return write;
	}

}

/*
	testing thread: cnt and list are shared resource guarded by ReadWriteLock
*/
class MyRunnable implements Runnable{
	
	String name;
	List<String> list;
	ReadWriteLock lock;
	int[] cnt;
	
	public MyRunnable(int[] cnt, String name, ReadWriteLock l, List<String> list) {
		lock=l;
		this.name=name;
		this.list=list;
		this.cnt=cnt;
	}
	public void run() {
		
		for(int i=0;i<5;i++) {
			lock.acquireWriteLock();
			list.add("From "+name);
			cnt[0]+=1;
			// cnt is expected to be no more than 1
			System.out.println("Updated from "+name+", writers:"+cnt[0]);
			cnt[0]-=1;
			lock.releaseWriteLock();
		}
		
		for(int i=0;i<5;i++) {
			lock.acquireReadLock();
			System.out.println("Readers:"+lock.getReadLockCnt()+", List is:"+list);
			try { Thread.sleep(1000); }
			catch(InterruptedException e) {e.printStackTrace();}
			lock.releaseReadLock();
		}
	}
}