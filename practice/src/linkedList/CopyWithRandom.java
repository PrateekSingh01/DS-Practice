package linkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyWithRandom {

	static class Node{
		int val;
		Node next;
		Node random;
		Node(int x){
			val = x;
		}
	}
	static Map<Node,Node> lookup = new HashMap<>();
	 public Node copyRandomList(Node head) {
	        Node curr = head;
	        while(curr!=null) {
	        	Node newNode = new Node(curr.val);
	        	lookup.put(curr,newNode);
	        	curr = curr.next;
	        }
	        
	        curr = head;
	        while(curr!=null) {
	        	Node copyCurr = lookup.get(curr);
	        	copyCurr.next = lookup.get(curr.next);
	        	copyCurr.random = lookup.get(curr.random);
	        	curr = curr.next;
	        }
	        
	        return lookup.get(head);
	    }
	public static void main(String[] args) {

		
	}

}
