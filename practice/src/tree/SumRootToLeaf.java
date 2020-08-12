package tree;

import tree.DiameterOfTree.TreeNode;

public class SumRootToLeaf {

	static class TreeNode {
		int val;
		TreeNode right; 
		TreeNode left ;

		TreeNode(int x) {
			val = x;
		}
	}

	static int ans;
	static void dfs(TreeNode curr, int sumTillHere) {
		if(curr== null) {
//			ans +=sumTillHere;
			return;
		}
		if(curr.left==null&&curr.right==null) {
			ans+=sumTillHere*10+curr.val;
			return;
		}else {
			dfs(curr.right,sumTillHere*10+curr.val);
			dfs(curr.left,sumTillHere*10+curr.val);
		}
		
		
//		dfs(curr.right,sumTillHere*10+curr.val);
	}
	static int sumNumbers(TreeNode root) {
		int ans =-1;
		dfs(root,0);
		return ans/2;
		
	}

	public static void main(String[] args) {
		TreeNode l0 = new TreeNode(0);
		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(2);
		TreeNode l3 = new TreeNode(3);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(6);
		TreeNode l7 = new TreeNode(7);
		TreeNode l8 = new TreeNode(8);
		TreeNode l9 = new TreeNode(9);
//		
//		l1.left=l2;
//		l1.right=l3;
		l4.left = l9;
		l4.right=l0;
		l9.left=l5;
		l9.right=l1;
		sumNumbers(l4);

	}

}
