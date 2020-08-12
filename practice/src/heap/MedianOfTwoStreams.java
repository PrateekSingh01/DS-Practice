package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfTwoStreams {
	static PriorityQueue<Integer> minheap;
	static PriorityQueue<Integer> maxheap;
	  public MedianOfTwoStreams() {
	        minheap = new PriorityQueue<Integer>();
	        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
	    }
	    
	    public void addNum(int num) {
	        maxheap.offer(num);
	        minheap.offer(maxheap.poll());
	        
	        if(!minheap.isEmpty()&&minheap.size()>maxheap.size()) {
	        	maxheap.offer(minheap.poll());
	        }
	    }
	    
	    public double findMedian() {
	    	if(maxheap.isEmpty()) {
	    		return minheap.poll();
	    	}
	        return minheap.size()==maxheap.size()?(minheap.poll()+maxheap.poll())/2:minheap.poll();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
