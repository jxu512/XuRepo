package demos.coding;

import java.util.ArrayList;
import java.util.List;

// Main class
public class CurrencyRate {

	List<Rate> direct = null;
	List<List<String>> result=null;
	List<String> temp=null;
	
	public CurrencyRate() {
		
		temp=new ArrayList<String>();
		result=new ArrayList<List<String>>();
		initRates();
		temp.add("GBP");	// Start with GPB -> find AUD
		findRateChain();
		// 
		System.out.println("All possible convertion for C to D:");
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
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		CurrencyRate Rates = new CurrencyRate();
		
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