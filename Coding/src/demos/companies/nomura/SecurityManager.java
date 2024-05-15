/*

Customer	Security	Qty
ABC			Tesla		100
XYZ			Apple		200
ABC			Tesla		-20
XYZ			Apple		-80

Calculate net qty

*/
package demos.companies.nomura;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class SecurityManager {

	public static void main(String[] args) {
		List<Order> orders=new ArrayList<>();
		orders.add(new Order(new CustSecurity("ABC","Telsa"),200));
		orders.add(new Order(new CustSecurity("ABC","Telsa"),-50));
		orders.add(new Order(new CustSecurity("ABC","Apple"),200));
		orders.add(new Order(new CustSecurity("ABC","Apple"),160));
		orders.add(new Order(new CustSecurity("XYZ","Telsa"),220));
		orders.add(new Order(new CustSecurity("XYZ","Telsa"),-100));
		orders.add(new Order(new CustSecurity("XYZ","Apple"),250));
		orders.add(new Order(new CustSecurity("XYZ","Apple"),130));
		orders.add(new Order(new CustSecurity("C123","IBM"),100));
		orders.add(new Order(new CustSecurity("C123","Telsa"),210));

		SecurityManager cs = new SecurityManager();
		System.out.println("For loop:"+cs.calcQty(orders).toString());
		System.out.println("Stream:  "+cs.calcQtyStream(orders));
	}
	// Traditional
	public Map<CustSecurity, Integer> calcQty(List<Order> orders) {
		Map<CustSecurity, Integer> map = new HashMap<>();
		
		for(Order o: orders) {
			CustSecurity custSecurity = o.getCustSecurity();
			if(!map.containsKey(custSecurity)) map.put(custSecurity, o.qty);
				else map.put(custSecurity, map.get(custSecurity)+o.qty);
		}
		return map;
	}
	// Stream
	public Map<CustSecurity, Integer> calcQtyStream(List<Order> orders) {
		Map<CustSecurity, Integer> map;
		map = orders.stream().collect(Collectors.groupingBy(Order::getCustSecurity,TreeMap::new,Collectors.summingInt(o->o.qty)));
		// Or in multi steps
		Function<Order, CustSecurity> classifier = //order -> order.custSecurity;	// lambda
		new Function<Order, CustSecurity>() {
			@Override
			public CustSecurity apply(Order order) {
				return order.getCustSecurity();
			}
		};
		Supplier<Map<CustSecurity, Integer>> supplier = TreeMap::new;	// lambda
		ToIntFunction<Order> summing = order -> order.qty;
		map = orders.stream().collect(Collectors.groupingBy(classifier, supplier, Collectors.summingInt(o->o.qty)));

		// Combined result
		List<Order> list = orders.stream()
				.collect(
						Collectors.groupingBy(order -> order.getCustSecurity(), Collectors.summingInt(o->o.qty))
				)
				.entrySet().stream()
				.map(e->new Order(e.getKey(),e.getValue()))
				//.sorted()
				.sorted((o1, o2) -> o1.qty == o2.qty ? 0 : (o1.qty < o2.qty ? -1 : 1))
				.collect(Collectors.toList());
		System.out.println("Total orders sorted: " + list);

		Map<CustSecurity, List<Order>> m1 =
				orders.stream().collect(
						Collectors.groupingBy(Order::getCustSecurity)
				);

		return map;
	}
}

class Order implements Comparable<Order>{
	private final CustSecurity custSecurity;
	int qty;
	public Order(CustSecurity custSecurity,int q) {
		this.custSecurity = custSecurity;
		qty=q;
	}
	public CustSecurity getCustSecurity() {
		return custSecurity;
	}

	@Override
	public int compareTo(Order o) {
		if (qty == o.qty) {
			return 0;
		} else {
			return qty < o.qty ? 1 : -1;
		}
	}
	@Override
	public String toString() {
		return custSecurity.toString() + ":" + qty;
	}
}
class CustSecurity implements Comparable{
	String cust;
	String security;

	public CustSecurity(String c, String s) {
		cust=c;
		security=s;
	}
	public String toString() {
		return cust+"-"+security;
	}
	// To use CustSecurity as hask key, must override equals and hashCode
	// If equals not overriden, every entry is treated as a distinct object per Object.equals()
	//*@Override
	public boolean equals(Object o) {
		if(o==null || ! (o instanceof CustSecurity)) return false;
		CustSecurity co = (CustSecurity)o;
		return cust.equals(co.cust) && security.equals(co.security);
	}//*/
	@Override
	public int hashCode() {
		return cust.hashCode()+security.hashCode();
	}

	@Override
	public int compareTo(Object o) {

		if (!(o instanceof CustSecurity)) {
			return 0;
		}

		return this.toString().compareTo(o.toString());
	}
}