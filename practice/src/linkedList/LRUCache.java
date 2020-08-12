package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	static Map<Integer, ListNode> lookup;
	static ListNode head, tail;
	static int cap, sz;
	static int curr;

	static class ListNode {
		int val;
		int key;
		ListNode prev;
		ListNode next;

		ListNode(int x, int y) {
			key = x;
			val = y;
		}
	}

	public LRUCache(int capacity) {
		cap = capacity;
		lookup = new HashMap<Integer, LRUCache.ListNode>();
	}

	public int get(int key) {
		int result = -1;
		ListNode node = lookup.get(key);
		if (node != null) {
			result = node.val;
			moveToHead(node);
		}
		return result;
	}

	static void moveToHead(ListNode node) {
		if (node == head)
			return;
		if(node==tail) {
			tail = tail.prev;
			tail.next=null;
			
		}else {
			ListNode tmp = node;
			tmp.prev.next=tmp.next;
			tmp.next.prev = tmp.prev;
		}
		
		node.next=head;
		head.prev=node;
		head=node;
		return;
	}

	public void put(int key, int value) {
		ListNode node = new ListNode(key, value);
		if (curr >= cap) {
			lookup.remove(tail.key);
			tail = tail.prev;
			if (tail == null) {
				head = null;
			}
			curr--;
		}

		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		lookup.put(key, node);
		curr++;
	}

	public static void main(String[] args) {
		LRUCache o = new LRUCache(1);
//		o.put(1, 1);
		o.put(2, 1);
		o.get(1);
//		o.get(2);
		o.put(3, 2);
		o.get(3);
		o.get(2);
		o.put(4, 3);
//		o.put(4, 1);
		o.get(2);
		o.get(3);
		o.get(4);

	}

}
