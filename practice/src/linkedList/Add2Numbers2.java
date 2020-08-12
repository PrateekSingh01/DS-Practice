package linkedList;

public class Add2Numbers2 {

	static class ListNode {
		int val;
		ListNode next;
		ListNode random;

		ListNode(int x) {
			val = x;
		}

		public ListNode() {
		}
	}
	static int carry;
	 static int getLen(ListNode node) {
			int size = 0;
			ListNode curr = node;
			while (curr != null) {
				curr = curr.next;
				size++;
			}
			return size;
		}
	static ListNode partialSum(ListNode l1, ListNode l2) {
		ListNode node;
		if (l1.next == null && l2.next == null) {
			int val = l1.val + l2.val;
			carry = val / 10;
			node = new ListNode(val % 10);
			return node;
		}

		node = new ListNode();
		node.next = partialSum(l1.next, l2.next);
		int val = l1.val + l2.val + carry;
		carry = val / 10;
		node.val = val % 10;
		return node;

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
		int sizeOfL1 = getLen(l1);
		int sizeOfL2 = getLen(l2);
        ListNode node = new ListNode();
        node.next = moveForward(l1, l2, sizeOfL1, sizeOfL2);
        if(carry>0){
            node.val=carry;
            return node;
        }
		return node.next;

	}

	static ListNode moveForward(ListNode l1, ListNode l2, int sizeOfL1, int sizeOfL2) {
		ListNode curr = new ListNode();
		if (sizeOfL1 > sizeOfL2) {
			curr.next = moveForward(l1.next, l2, sizeOfL1 - 1, sizeOfL2);
			int val = l1.val + carry;
			carry = val / 10;
			curr.val = val % 10;
			return curr;
		} else if (sizeOfL2 > sizeOfL1) {
			curr.next = moveForward(l1, l2.next, sizeOfL1, sizeOfL2 - 1);
			int val = l2.val + carry;
			carry = val / 10;
			curr.val = val % 10;
			return curr;
		} else {
			return partialSum(l1, l2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
