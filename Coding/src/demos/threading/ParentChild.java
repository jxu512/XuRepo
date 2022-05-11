package demos.threading;

public class ParentChild {

	public static void main(String[] args) {
		
		System.out.println("main before: "+Thread.activeCount());
		for(int i=0;i<3;i++) new Thread(new Parent()).start();
		System.out.println("main after: "+Thread.activeCount());
		System.out.println("main...ending");
	}
}

class Parent implements Runnable {

	@Override
	public void run() {

		System.out.println("parent before: "+Thread.activeCount());
		new Thread(new Child(Thread.currentThread())).start();
		System.out.println("parent after: "+Thread.activeCount());
	
		for(int i=0;i<10;i++) {
			System.out.print("Parent..."+i);
			try { Thread.sleep(1000); }
			catch(InterruptedException e) {}
		}
		System.out.println("Parent...exiting");
	}
}
// Child thread can survive after parent thread terminating 
class Child implements Runnable {

	Thread p;
	
	public Child(Thread p) {
		this.p=p;
	}
	@Override
	public void run() {

		System.out.println("Waiting for parent:"+p.getName());
		try { p.join(); }
		catch(InterruptedException e) {}
		System.out.println(p.getName()+" ended");
		
		for(int i=0;i<10;i++) {
			try { Thread.sleep(1000); }
			catch(InterruptedException e) {}
			System.out.format("child: %d, ",Thread.activeCount());
		}
		System.out.println("\nChild...exiting, ");
	}
}
