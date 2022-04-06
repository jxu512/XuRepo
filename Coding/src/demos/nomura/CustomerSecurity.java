/*

Customer	Security	Qty
ABC			Tesla		100
XYZ			Apple		200
ABC			Tesla		-20
XYZ			Apple		-80

Calculate net qty

*/
package demos.nomura;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerSecurity {

	public Map<CustSecurity, Integer> calcQut(List<Order> orders) {
		Map<CustSecurity, Integer> map = new HashMap<>();
		
		for(Order o: orders) {
			CustSecurity cs = new CustSecurity(o.cust,o.security);
			if(!map.containsKey(cs)) map.put(cs, o.qty);
				else map.put(cs, map.get(cs)+o.qty);
		}
		return map;
	}
}

class Order{
	String cust;
	String security;
	int qty;
}
class CustSecurity{
	String cust;
	String security;

	public CustSecurity(String c, String s) {
		cust=c;
		security=s;
	}
	// To use CustSecurity as hask key, must override equals and hashCode
	@Override
	public boolean equals(Object o) {
		if(o==null || ! (o instanceof CustSecurity)) return false;
		CustSecurity co = (CustSecurity)o;
		return cust.equals(co) && security.equals(co.security);
	}
	@Override
	public int hashCode() {
		return cust.hashCode()+security.hashCode();
	}
}