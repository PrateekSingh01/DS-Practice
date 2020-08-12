package tree;

import java.util.Arrays;

public class TreeFromInPreOrder {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	static int idxOfRoot(int[] inorder, int root) {
		int idx = -1;
		if(inorder.length==0) {
			return idx;
		}
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root) {
				idx = i;
				return idx;
			}
		}
		return idx;
	}

	static TreeNode buildTree(int[] preorder, int[] inorder) {
		int rootIdx=-1;
		if(preorder.length!=0) {
			 rootIdx = idxOfRoot(inorder, preorder[0]);
		}
		if(inorder.length==0){
			return null;
		}
		if(rootIdx==-1||rootIdx==inorder.length) {
			return null;
		}
		TreeNode cRoot = new TreeNode(preorder[0]);
		
		cRoot.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIdx+1),
				Arrays.copyOfRange(inorder, 0, rootIdx));
		cRoot.right = buildTree(Arrays.copyOfRange(preorder, rootIdx+1, preorder.length),
				Arrays.copyOfRange(inorder, rootIdx+1, preorder.length));
		return cRoot;
	}

	public static void main(String[] args) {
		int a[]= {1,2,4,3,5,7,8,6};
		int b[]= {4,2,1,7,5,8,3,6};
		buildTree(a, b);

	}

}
