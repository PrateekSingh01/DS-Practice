package tree;


public class DiameterOfTree {
	static class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;
		TreeNode(int x) {
			val = x;
		}
	}
	
	int max = -9999999;
	 public int diameterOfBinaryTree(TreeNode root) {
	       if(root==null) {
	    	   return 0;
	       }
	       
	       int l = 1+diameterOfBinaryTree(root.left);
	       int r = 1+diameterOfBinaryTree(root.right);
	       max = Integer.max(max, l+r-1);
	       return Integer.max(l, r);
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

		l3.left = l5;
		l3.right = l1;
		l5.left = l6;
		l5.right = l2;
		l2.left = l7;
		l2.right = l4;
		l1.left = l0;
		l1.right = l8;

	}

}
