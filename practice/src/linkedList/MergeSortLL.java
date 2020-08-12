package linkedList;

public class MergeSortLL {

	static class ListNode{
		int val; 
		ListNode next;
		public ListNode(int x) {
			val =x;
		}
	}
	
	static ListNode merge(ListNode a, ListNode b) {
		ListNode p = new ListNode(0),l=p;
		while(a!=null||b!=null) {
			if(a.val<b.val) {
				p.next = a;
				a=a.next;
			}else {
				p.next = b;
				b=b.next;
			}
			p = p.next;
		}
		return l.next;
	}
	static ListNode mergeSort(ListNode head) {
		 if(head==null||head.next==null) {
			 return head;
		 }


		 ListNode slow = head;
		 ListNode fast = head;
		 while(fast.next!=null) {
			 slow= slow.next;
			 fast= fast.next.next;
		 }
		 mergeSort(head);
		 mergeSort(slow);
		return merge(head,slow);
	}
	public static void main(String[] args) {
		

	}

}
