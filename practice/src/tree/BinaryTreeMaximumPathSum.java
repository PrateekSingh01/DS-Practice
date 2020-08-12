package tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeMaximumPathSum {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int ans=-999;
	static Map<TreeNode,Integer> lookup;
	static int helper(TreeNode curr) {
		if(curr == null) {
			lookup.put(curr,0);
			return 0;
		}
		int l = helper(curr.left);
		int r = helper(curr.right);
		if(l<0) {
			l=0;
		}
		if(r<0) {
			r=0;
		}
		int adder = Integer.max(l, r);
		int sum = curr.val+l+r;
//		int sum1 = curr.val+Integer.max(lookup.get(curr.left),lookup.get(curr.right));
		lookup.put(curr, curr.val+adder);
		ans = Integer.max(ans, sum);
//		lookup.put(curr,sum);
		return sum;
	}
	
	static void traverse(TreeNode curr) {
		if(curr==null) {
			return;
		}
		int ans1 = curr.val+lookup.get(curr.left)+lookup.get(curr.right);
		ans = Integer.max(ans, ans1);
		traverse(curr.left);
		traverse(curr.right);
	}
	static int maxPathSum(TreeNode root) {
		helper(root);
		traverse(root);
		return ans;
	}

	public static void main(String[] args) {

		lookup = new HashMap<BinaryTreeMaximumPathSum.TreeNode, Integer>();
		TreeNode l10 = new TreeNode(-10);
		TreeNode l9 = new TreeNode(9);
		TreeNode l20 = new TreeNode(20);
		TreeNode l15 = new TreeNode(15);
		TreeNode l4 = new TreeNode(4);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(6);
		TreeNode l7 = new TreeNode(7);
		TreeNode l8 = new TreeNode(8);

		
		l10.left=l9;
		l10.right=l20;
		l20.left=l15;
		l20.right=l7;
		
		System.out.println(maxPathSum(l10));
	}

}
