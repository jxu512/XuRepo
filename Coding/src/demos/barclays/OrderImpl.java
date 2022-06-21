package demos.barclays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrderImpl implements Ordering{

	// List of ordered relations
	List<Object[]> list = new ArrayList<>();
	
	// obj[0] greater than obj[1]
	@Override
	public void addRelation(Object a, Object b, boolean greater) {

		Object[] obj=new Object[2];
		if(greater) { obj[0]=a;obj[1]=b;}
			else { obj[0]=b;obj[1]=a;}
		list.add(obj);
	}

	@Override
	public boolean isGreater(Object x, Object y) {

		return bfs(x,y);
	}

	// Given object x and y, use BFS to find out relation
	private boolean bfs(Object x, Object y) {

		Queue<Object> queue = new LinkedList<Object>();
		queue.add(x);
		while(!queue.isEmpty()) {
			
			Object cur = queue.poll();
			if(cur.equals(y)) return true;
			// Finding matching relations
			findRel(cur, queue);
		}
		
		return false;
	}

	private void findRel(Object cur, Queue<Object> queue) {

		Iterator<Object[]> it = list.iterator();
		while(it.hasNext()) {
			Object[] temp=it.next();
			if(temp[0].equals(cur)) queue.offer(temp[1]);
		}
	}

	public static void main(String[] args) {
		
		OrderImpl impl = new OrderImpl();
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		Object obj4 = new Object();
		Object obj5 = new Object();
		impl.addRelation(obj1,obj2, true);
		impl.addRelation(obj2,obj3, true);
		impl.addRelation(obj2,obj4, true);
		impl.addRelation(obj4,obj3, true);
		impl.addRelation(obj4,obj5, true);
		
		boolean b = impl.isGreater(obj2, obj5);
		System.out.println(b?"Greated than":"Not greater than");
	}
}
