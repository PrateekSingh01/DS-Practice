package heap;

import java.util.PriorityQueue;

public class MergeKSortedList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode ans = new ListNode(-1),dummy=ans;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(5,(w1,w2)->w1.val-w2.val);
		for(int i=0;i<lists.length;i++) {
			pq.offer(lists[i]);
		}
		
		while(!pq.isEmpty()) {
			ListNode l = pq.poll();
			if(l.next!=null) {
				pq.offer(l.next);
			}
			dummy.next = new ListNode(l.val);
		}
		return ans.next;
	}

	public static void main(String[] args) {

	}

}
