package demos.coding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class UndergroundSystem {


    Map<String,Map<Integer,Integer>> entries=null;
    Map<String,Map<Integer,Integer>> exits=null;
    
    public UndergroundSystem() {
        entries = new HashMap<String, Map<Integer,Integer>>();
        exits = new HashMap<String, Map<Integer,Integer>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
    	
        if(entries.get(stationName)==null) {
        	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        	map.put(id, t);
        	entries.put(stationName, map);
        }
        else {
        	entries.get(stationName).put(id, t);
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(exits.get(stationName)==null) {
        	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        	map.put(id, t);
        	exits.put(stationName, map);
        }
        else {
        	exits.get(stationName).put(id, t);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double average=0d;
    	Map<Integer,Integer> start = entries.get(startStation);
    	Map<Integer,Integer> end = exits.get(endStation);
    	
    	Iterator<Integer> itStart = start.keySet().iterator();
        int customers=0;
    	while(itStart.hasNext()) {
    		int id = itStart.next();
    		if(end.get(id)!=null && start.get(id)!=null){
                customers++;
                average += ((double)end.get(id)-(double)start.get(id));
            }
    	}
    	return average/customers;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */