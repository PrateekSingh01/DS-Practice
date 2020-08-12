package linkedList;

import linkedList.Merge2SortedList.ListNode;

public class OddEvenList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	static ListNode oddEvenList(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode curr= head;
		ListNode even = curr.next;
		ListNode evenCopy=even;
		while(curr.next!=null&&curr.next.next!=null) {
			
			curr.next=curr.next.next;
			curr= curr.next;
			even.next=curr.next;
			even=even.next;
		}
		
		curr.next=evenCopy;
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		oddEvenList(l1);

	}

}
