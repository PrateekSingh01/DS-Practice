package linkedList;

public class MergeTwoNumbers {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	static ListNode helper(ListNode l1, ListNode l2,int carry) {
		ListNode newNode = null;
		if(l1!=null&&l2!=null) {
			int ans = l1.val+l2.val+carry;
			newNode = new ListNode(ans%10);
			newNode.next = helper(l1.next, l2.next, ans/10);
		}
		if(l1==null&&l2==null) {
			if(carry==1) {
				newNode = new ListNode(1);
				newNode.next=null;
				return newNode;
			}else {
				return null;
			}
		}
		if(l2==null) {
			int ans = l1.val+carry;
			newNode = new ListNode(ans%10);
			newNode.next = helper(l1.next, l2, ans/10);
		}
		if(l1==null) {
			int ans = l2.val+carry;
			newNode = new ListNode(ans%10);
			newNode.next = helper(l1, l2.next, ans/10);
		}
		
		return newNode;
		
	}
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return helper(l1,l2,0);
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(4);

//		l1.next = l2;
		//l2.next = l3;
//		
//		l4.next = l5;
//		l5.next = l6;
		
		ListNode ans = addTwoNumbers( l5, l4);
		
		while(ans!=null) {
			System.out.println(ans.val);
			ans = ans.next;
		}
	}

}
