package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LevelOrderTraversal {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<TreeNode> l1 = new ArrayList<TreeNode>();
		l1.add(root);
		Iterator<TreeNode> iterate = l1.iterator();
		List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
		// levelOrder.add();
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(root.val);
		levelOrder.add(l3);
		Iterator<TreeNode> iterate2 = l1.iterator();
		List<TreeNode> l2 = new ArrayList<TreeNode>();

		while (iterate.hasNext()) {
			l3 = new ArrayList<Integer>();
			while (iterate2.hasNext()) {
				TreeNode curr = iterate2.next();
				if (curr.left != null) {
					l2.add(curr.left);
					System.out.println(curr.left.val);
					l3.add(curr.left.val);
				}
				if (curr.right != null) {
					l2.add(curr.right);
					System.out.println(curr.right.val);
					l3.add(curr.right.val);
				}

			}
			 iterate.next();

			if (l3.size() > 0) {
				l1 = new ArrayList<>(l2);
				iterate = l1.iterator();
				iterate2 = l1.iterator();
				l2 = new ArrayList<>();
				levelOrder.add(l3);
			}else {
				break;
			}
		}
		return levelOrder;
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
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.left = n6;
		n5.right = n7;
		levelOrderTraversal(n1);
		System.out.println("ssfsf");
	}

}
