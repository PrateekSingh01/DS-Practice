package linkedList;

import java.util.Collections;
import java.util.PriorityQueue;

public class SortTwoLinks {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	static class Items {
		int sum;
		ListNode nodes;

		Items(int sum, ListNode nodes) {
			this.sum = sum;
			this.nodes = nodes;
		}
	}

	static void sort(ListNode head, int k) {
		ListNode curr = head;
		PriorityQueue<Items> pq = new PriorityQueue<>(Collections.reverseOrder((w1,w2)->w1.sum-w2.sum));
		int counter = 0;
		int val = 0;
		boolean check=false;
		ListNode start = curr;
		ListNode prev = null;
		while (start != null) {
			if ((counter % k == 0 && check)||curr==null) {
				
				Items item = new Items(val, start);
				pq.offer(item);
				start = curr;
				prev.next = null;
				val = 0;
			}
			check=true;
			if(start==null)break;
			prev=curr;
			val += curr.val;
			curr = curr.next;
			counter++;
		}
		ListNode st=new ListNode(-1);
		ListNode header=pq.peek().nodes;
		while(!pq.isEmpty()) {
			if(st.next==null) {
				st.next = pq.poll().nodes;
			}
			st=st.next;
		}
		while(header!=null) {
			System.out.print(header.val+" ");
			header = header.next;
		}
	}

	public static void main(String[] args) {
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(4);
		ListNode l8 = new ListNode(5);
		ListNode l9 = new ListNode(7);

		l2.next = l5;
		l5.next = l0;
		l0.next = l8;
		l8.next = l3;
		l3.next = l9;
		l9.next = l1;
		l1.next = l4;
		l4.next = l7;
		l7.next = l6;
		sort(l2, 1);
	}

}
