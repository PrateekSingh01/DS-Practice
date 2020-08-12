package linkedList;

public class ReverseNodesInK {

	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int x) {
			val = x;
		}
	}
	
	
	 static ListNode reverseKGroup(ListNode head, int k) {
		 if(head==null) {
			 return null;
		 }
		 	ListNode curr=head;
		 	ListNode prev= null;
		 	ListNode next =null;
		 	int counter=0;
		 	ListNode dummy = head;
		 	
		 	while(counter<k&&dummy!=null) {
		 		dummy=dummy.next;
		 		counter++;
		 	}
		 	if(counter!=k) {
		 		return head;
		 	}
		 	counter=0;
		 	while(counter<k&&curr!=null) {
		 		next=curr.next;
		 		curr.next=prev;
		 		prev = curr;
		 		curr=next;
		 		counter++;
		 	}
		 	head.next = reverseKGroup(curr, k);
		 	return prev;
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
		l3.next=l4;
		l4.next = l5;
//		l5.next = l6;
		
		reverseKGroup(l1, 3);
	}

}
