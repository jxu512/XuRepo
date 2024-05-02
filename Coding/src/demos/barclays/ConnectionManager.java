package demos.barclays;

import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    int maxConn = 20;

    List<Connection> conns = new ArrayList<>();
    boolean[] available = new boolean[maxConn];

    public synchronized void stats() {
        int num = conns.size();
        int availableableConnections = 0;
        for (int i = 0; i < num; i++)
            if (available[i]) availableableConnections++;
        System.out.format("Connection: %d with %d availableable\n", num, availableableConnections);
    }

    public synchronized void releaseConnection(Connection c) {

        for (int i = 0; i < conns.size(); i++) {
            if (conns.get(i) == c) {
                available[i] = false;
                System.out.println(Thread.currentThread().getName() + " released...");
                notify();
            }
        }
    }

    public synchronized Connection getConnection() {

        while (true) {

            // Reuse an existing availableable connection
            for (int i = 0; i < conns.size(); i++) {
                if (!available[i]) {
                    available[i] = true;
                    System.out.println(Thread.currentThread().getName() + " got existing...");
                    return conns.get(i);
                }
            }
            // Create new connection if maxConn hasn't been reached yet
            if (conns.size() < maxConn) {
                Connection c = new Connection();
                available[conns.size()] = true;
                conns.add(c);
                System.out.println(Thread.currentThread().getName() + " got new...");
                return c;
            } else {  // maxConn reached, wait for availableable connection
                System.out.println(Thread.currentThread().getName() + " waiting...");
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
        Thread t[] = new Thread[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Thread() {
                public void run() {
                    Connection c = m.getConnection();
                    m.stats();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    m.releaseConnection(c);
                }
            };
            t[i].setName("t" + i);
            t[i].start();
        }
        for (int i = 0; i < n; i++)
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        m.stats();
    }
}

class Connection {
    int id;
    String name;
}