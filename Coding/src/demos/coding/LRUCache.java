package demos.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

	Map<Integer, Entry> map = null;
	long count;
	int capacity;
	 public LRUCache(int capacity) {
		        count=0;
		        this.capacity=capacity;
		        map = new HashMap<Integer, Entry> (capacity);
	}
		    
	public int get(int key) {
	    if(map.get(key)!=null){  
            map.get(key).lastUsed=++count;
	        return map.get(key).value;
        }
    return -1;
	}
		    
	public void put(int key, int value) {
		        
		        if(map.size()==capacity) removeLSU();
		        map.put(key, new Entry(key,value));
	}
	private void removeLSU() {
		        
		        List<Entry> list=new ArrayList(map.values());
		        Collections.sort(list, Comparator.comparingLong(entry->entry.lastUsed));
		        map.remove(list.get(0).key);
	}
	public static void main(String[] args) {
		int res=-1;
		LRUCache lru = new LRUCache(2);
		res = lru.get(2);
		lru.put(2, 6);
		res = lru.get(1);
		lru.put(1, 5);
		lru.put(1, 2);
		lru.get(1);
		lru.get(2);
		
		//System.out.println(lru.map);
		lru.map.forEach((key,value)->System.out.println(value));
	}
}

class Entry {
	int key;
	int value;
	long lastUsed;
		    
	public Entry(int key, int value) {
		this.key=key;
		this.value=value;
		lastUsed = -1;
		}
	public String toString() {
		return key+"/"+value+":"+lastUsed;
	}
}
		/**
		 * Your LRUCache object will be instantiated and called as such:
		 * LRUCache obj = new LRUCache(capacity);
		 * int param_1 = obj.get(key);
		 * obj.put(key,value);
		 */