package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.DiameterOfTree.TreeNode;

public class ZigZagLevelOrderTraversal {

	static class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;

		TreeNode(int x) {
			val = x;
		}
	}

	static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();	
		if (root == null) {
			return ans;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> innerList = new ArrayList<Integer>();
			int sz = queue.size();
			for (int i = 0; i < sz; i++) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				innerList.add(node.val);

			}
			if (ans.size() % 2 != 0) {
				Collections.reverse(innerList);

			}
			if (innerList.size() > 0) {
				ans.add(innerList);
			}

		}
		return ans;

	}

	public static void main(String[] args) {
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);

		l1.left = l2;
		l2.left = l4;
		l2.right = l5;
		l1.right = l3;
		zigzagLevelOrder(l1);

	}

}
