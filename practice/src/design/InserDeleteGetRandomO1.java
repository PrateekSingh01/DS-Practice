package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InserDeleteGetRandomO1 {

	List<Integer> list;
	Map<Integer,Integer> map;
	int size=0;
	 /** Initialize your data structure here. */
    public InserDeleteGetRandomO1() {
        list  = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
        	return false;
        }else {
        	list.add(size, val);
        	map.put(val, size);
        	size++;
        	return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
        	int index = map.get(val);
        	
        	int lastVal = list.get(size-1);
        	map.remove(val);
        	list.remove(size-1);
        	size--;
        	if(index!=list.size()) {
        		list.set(index, lastVal);
            	map.put(lastVal, index);
        	}
        	return true;
        }else {
        	return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = (int)(Math.random()*(list.size()-1));
        return list.get(idx);
    }
	public static void main(String[] args) {
		InserDeleteGetRandomO1 obj = new InserDeleteGetRandomO1();
		obj.insert(1);
		obj.remove(2);
		obj.insert(2);
		System.out.println(obj.getRandom());
		obj.remove(1);
		obj.insert(2);
		System.out.println(obj.getRandom());
		
	}

}
