package linkedList;

import linkedList.ReverseNodesInK.ListNode;

public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	static ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			prev = curr;

			curr = next;
		}
		return prev;

	}

	static void reorderList(ListNode head) {
		ListNode curr = head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode list2 = reverse(slow.next);
		slow.next = null;
		ListNode reversePtr = list2;
		ListNode currNext = null;
		ListNode reversePtrNext = null;
		while (curr != null && reversePtr != null) {
			if (curr != null) {
				currNext = curr.next;
				curr.next = reversePtr;
				curr = currNext;
			}
			if (list2 != null) {
				reversePtrNext = list2.next;

				reversePtr.next = currNext;

				reversePtr = reversePtrNext;
			}

		}
		System.out.println("fdfsfdf");
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		reorderList(l1);
	}

}
