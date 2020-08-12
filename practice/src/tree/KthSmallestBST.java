package tree;

public class KthSmallestBST {

	static class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;

		TreeNode(int x) {
			val = x;
		}
	}

	static int val = 0, ans = -1;

	static void helper(TreeNode node, int k) {
		if (node == null) {
			return ;
		}
		if(val>k) {
			return ;
		}
		kthSmallest(node.left, val);
		val++;
		if (val == k) {
			ans = node.val;
		}
		kthSmallest(node.right, val);
		

	}

	static int kthSmallest(TreeNode root, int k) {
		helper(root,k);
		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
