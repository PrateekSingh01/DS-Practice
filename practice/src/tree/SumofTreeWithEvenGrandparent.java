package tree;

public class SumofTreeWithEvenGrandparent {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;

		}
	}

	static int sum;

	static void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.val % 2 == 0) {
			if (node.left != null && node.left.left != null) {
				sum += node.left.left.val;
			}
			if (node.left != null && node.left.right != null) {
				sum += node.left.right.val;
			}
			if (node.right != null && node.right.left != null) {
				sum += node.right.left.val;
			}
			if (node.right != null && node.right.right != null) {
				sum += node.right.right.val;
			}
		}
		dfs(node.left);
		dfs(node.right);
	}

	static int sumEvenGrandparent(TreeNode root) {
		int ans = -1;
		sum=0;
		dfs(root);
		ans = sum;
		System.out.println(ans);
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
