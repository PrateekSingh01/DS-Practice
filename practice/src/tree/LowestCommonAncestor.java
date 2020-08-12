package tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
	static class TreeNode {
		int val;
		TreeNode right=null;
		TreeNode left=null;

		TreeNode(int x) {
			val = x;
		}
	}

	static boolean helper(TreeNode curr, int ans1,int ans2,int a) {
		if(curr==null) {
			return false;
		}
		if(curr.val ==ans1 || curr.val==ans2) {
			return true;
		}
		
		return false;
	}
	static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
		TreeNode ans = new TreeNode(-1);
		
 		System.out.println("fdff");
		return ans;
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
		
		l3.left=l5;
		l3.right=l1;
		l5.left=l6;
		l5.right=l2;
		l2.left=l7;
		l2.right=l4;
		l1.left=l0;
		l1.right=l8;
		lowestCommonAncestor(l3,7,9);
		System.out.println("dsds");
	}

}
