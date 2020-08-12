package linkedList;

public class RemoveNthFromEndOnePass {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int x) {
			val = x;
		}
	}

	static public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode second = head;
		ListNode first = head;
		ListNode prev = null;
		if (head.next == null) {
			return null;
		}
		int itr = 1;
		while (itr != n) {
			second = second.next;
			itr++;
		}
		while (second.next != null) {
			second = second.next;
			prev = first;
			first = first.next;
		}
		if (first.next != null) {
			first.val = first.next.val;
			first.next = first.next.next;
		} else {

			first = null;
			prev.next = first;
		}

		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
//		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(5);

//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;

		l1 = removeNthFromEnd(l1, 1);
		while (l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}

}
