package linkedList;

public class SwapNodesInPair {

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	static ListNode swapPairs(ListNode head) {
		
		ListNode prev =head;
		ListNode curr = head.next,p=curr;
		while(true) {
			ListNode next = curr.next;
			curr.next=prev;
			
			if(next==null || next.next==null) {
				prev.next = next;
				break;
			}
			prev.next = next.next;
			prev= next;
			curr = next.next;
		} 
		
		return p;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);

		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		swapPairs(l1);
		System.out.println("fsf");
	}

}
