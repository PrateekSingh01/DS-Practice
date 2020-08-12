package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.LevelOrderTraversal.TreeNode;

public class RightSideTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;

		}
	}

	static List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> ans = new ArrayList<Integer>();
		if (root == null)
			return ans;
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode p = q.poll();
				if (p.right != null)
					q.offer(p.right);
				if (p.left != null)
					q.offer(p.left);
				if (i == 0)
					ans.add(p.val);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
//		n2.left = n3;
		n3.right=n4;
		n2.right = n5;
//		n5.left = n6;
//		n5.right = n7;
		List<Integer> ans = rightSideView(n1);
		for(int v:ans) {
			System.out.println(v);
		}
	}

}
