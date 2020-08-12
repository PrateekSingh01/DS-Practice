package linkedList;

public class Merge2SortedList {

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	  static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1==null&&l2==null) {
	        	return null;
	        }
	        if(l1!=null&&l2!=null) {
	        	if(l1.val<l2.val) {
	        		l1.next = mergeTwoLists(l1.next, l2);
	        	}else {
	        		l2.next = mergeTwoLists(l1, l2.next);
	        	}
	        	return l1.val<l2.val?l1:l2;
	        }
	        if(l1==null) {
	        	return l2;
	        }else {
	        	return l1;
	        }
	        
	    }
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		
		l1.next = l3;
		l2.next = l4;
		l3.next = l5;
		l4.next = l6;

		ListNode ans = mergeTwoLists(l1, l6);
		System.out.println("gfgf");
	}

}
