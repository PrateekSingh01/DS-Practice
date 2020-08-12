package tree;

public class ValidateBST {

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			val =x;
		}
	}
	
	static boolean ans=true;
	 static void isValidBSTHelper(TreeNode node,int min, int max) {
	        if(node==null) {
	        	return;
	        }
	        if(node.val<=min||node.val>=max) {
	        	ans = false;
	        }
	        if(ans) {
	        	isValidBSTHelper(node.left, min, node.val);
		        isValidBSTHelper(node.right, node.val, max);
	        }
	    }
	public static void main(String[] args) {
		TreeNode l0 = new TreeNode(10);
		TreeNode l1 = new TreeNode(5);
		TreeNode l2 = new TreeNode(15);
		TreeNode l3 = new TreeNode(20);
		TreeNode l4 = new TreeNode(12);
		TreeNode l5 = new TreeNode(5);
		TreeNode l6 = new TreeNode(6);
		TreeNode l7 = new TreeNode(7);
		TreeNode l8 = new TreeNode(8);
		TreeNode l9 = new TreeNode(9);
		
		l0.left=l5;
		l0.right=l2;
		l2.left=l6;
		l2.right=l3;
		
		isValidBSTHelper(l0,Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println(ans);

	}

}
