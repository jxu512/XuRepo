package demos.barclays;

import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    int maxConn=20;

    List<Connection> conns = new ArrayList<>();
    int[] avail = new int[maxConn];

    public synchronized void stats() {
    	int num = conns.size();
    	int available=0;
    	for(int i=0;i<num;i++) 
    		if(avail[i]==0) available++;
    	System.out.format("Connection: %d with %d available\n", num, available);
    }
    public synchronized void releaseConnection(Connection c){
    	
    	for(int i=0;i<conns.size();i++) {
    		if(conns.get(i)==c) {
    			avail[i]=0;
    			System.out.println(Thread.currentThread().getName()+" released...");
    			notify();
    		}
    	}
    }
    public synchronized Connection getConnection(){
    
	    while(true) {
	        for(int i=0;i<conns.size();i++){
	            if(avail[i]==0) {
		            avail[i]=1;
		        	System.out.println(Thread.currentThread().getName()+" got existing...");
		            return conns.get(i);
	          }
	        }
	        // Below maxConn
	        if(conns.size()<maxConn){
		        Connection c = new Connection();
		        avail[conns.size()]=1;
		        conns.add(c);
	        	System.out.println(Thread.currentThread().getName()+" got new...");
		        return c;
	        }
	        else {  // maxConn reached
	        	System.out.println(Thread.currentThread().getName()+" waiting...");
	            try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	        }
        }
    }

    public static void main(String[] args) {
    	
    	ConnectionManager m = new ConnectionManager();
    	int n = 55;
    	Thread t[]=new Thread[n];
    	for(int i=0;i<n;i++) {
    		t[i]=new Thread() {
    			public void run() {
    				Connection c = m.getConnection();
    				m.stats();
    		        try { Thread.sleep(5000); }
    		        catch(InterruptedException e) {e.printStackTrace();}
    				m.releaseConnection(c);
    			}
    		};
    		t[i].setName("t"+i);
    		t[i].start();
    	}
    	for(int i=0;i<n;i++)
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	m.stats();
    }
}

class Connection{
	int id;
	String name;
}