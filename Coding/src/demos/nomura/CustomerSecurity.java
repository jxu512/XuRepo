/*

Customer	Security	Qty
ABC			Tesla		100
XYZ			Apple		200
ABC			Tesla		-20
XYZ			Apple		-80

Calculate net qty

*/
package demos.nomura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerSecurity {

	public static void main(String[] args) {
		List<Order> orders=new ArrayList<>();
		orders.add(new Order("ABC","Telsa",200));
		orders.add(new Order("ABC","Telsa",-100));
		orders.add(new Order("ABC","Apple",200));
		orders.add(new Order("ABC","Apple",100));
		orders.add(new Order("XYZ","Telsa",200));
		orders.add(new Order("XYZ","Telsa",-100));
		orders.add(new Order("XYZ","Apple",200));
		orders.add(new Order("XYZ","Apple",100));
		
		CustomerSecurity cs = new CustomerSecurity();
		System.out.println("For loop:"+cs.calcQty(orders));
		System.out.println("Stream:  "+cs.calcQtyStream(orders));
	}
	// Traditional
	public Map<CustSecurity, Integer> calcQty(List<Order> orders) {
		Map<CustSecurity, Integer> map = new HashMap<>();
		
		for(Order o: orders) {
			CustSecurity cs = new CustSecurity(o.cust,o.security);
			if(!map.containsKey(cs)) map.put(cs, o.qty);
				else map.put(cs, map.get(cs)+o.qty);
		}
		return map;
	}
	// Stream
	public Map<CustSecurity, Integer> calcQtyStream(List<Order> orders) {
		Map<CustSecurity, Integer> map = 
			orders.stream().collect(Collectors.groupingBy(o->new CustSecurity(o.cust,o.security), Collectors.summingInt(o->o.qty)));
		
		return map;
	}
}

class Order{
	String cust;
	String security;
	int qty;
	public Order(String c,String s,int q) {
		cust=c;
		security=s;
		qty=q;
	}
}
class CustSecurity{
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
}