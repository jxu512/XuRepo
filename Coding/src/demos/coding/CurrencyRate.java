package demos.coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Main class
public class CurrencyRate {

	List<Rate> direct = null;
	List<List<String>> result=null;
	List<String> temp=null;
	
	public CurrencyRate() {
		initRates();
	}
	public void findAllConversions() {
		temp=new ArrayList<String>();
		result=new ArrayList<List<String>>();
		temp.add("GBP");	// Start with GPB -> find AUD
		findRateChain();
		// 
		System.out.println("All possible convertion for GBP to AUD:");
		result.forEach(route->System.out.println(route));
	}
	
	//Find conversion chain for GBP->AUD
	private void findRateChain() {
		
		for(Rate rate:direct) {
			String currentCcy = temp.get(temp.size()-1);
			if( (currentCcy.equals(rate.getFromCcy())||currentCcy.equals(rate.getToCcy()))
					&& ! (temp.contains(rate.getFromCcy())&&temp.contains(rate.getToCcy())) ) {
				String toAddCcy = rate.getFromCcy();
				if(temp.contains(toAddCcy)) toAddCcy = rate.getToCcy();
				temp.add(toAddCcy);
				if(!"AUD".equalsIgnoreCase(toAddCcy)) findRateChain();	// toCcy not matching toCcy AUD
					
					// Add to result
					if("AUD"==temp.get(temp.size()-1)) {
						List<String> matchRate = new ArrayList<String>();
						matchRate.addAll(temp);
						result.add(matchRate);
					}
					// Prepare for next round
					temp.remove(temp.size()-1);
			}
		}
		// No more unused direct route
		return;
	}
	private void initRates() {

		direct = new ArrayList<Rate>();
		direct.add(new Rate("USD","JPY",110f));
		direct.add(new Rate("USD","AUD",1.45f));
		direct.add(new Rate("JPY","GBP",0.0070f));
		
		System.out.println("Input Rate:");
		direct.forEach(Rate-> System.out.println(Rate));
	}
	private float findRateBFS() {
		
		float rate = 0.0f; 
		
		Queue<Rate> queue = new LinkedList<Rate>();
		List list = (List)queue;
		return rate;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		CurrencyRate rates = new CurrencyRate();
		rates.findAllConversions();
	}

	
}

// Inner class
class Rate {
	
	private String fromCcy, toCcy;
	float rate;
	
	public String getFromCcy() {
		return fromCcy;
	}

	public void setFromCcy(String fromCcy) {
		this.fromCcy = fromCcy;
	}

	public String getToCcy() {
		return toCcy;
	}

	public void setToCcy(String toCcy) {
		this.toCcy = toCcy;
	}

	
	public Rate(String fromCcy, String toCcy, float rate) {
		this.fromCcy=fromCcy;
		this.toCcy=toCcy;
		this.rate=rate;
	}
	
	public String toString() {
		return "["+fromCcy+"->"+toCcy+"]";
	}
}