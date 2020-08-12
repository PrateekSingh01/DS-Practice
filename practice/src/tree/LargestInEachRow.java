package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestInEachRow {

	static class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;

		TreeNode(int x) {
			val = x;
		}
	}
	
	 public List<Integer> largestValues(TreeNode root) {
	        List<Integer> ans = new ArrayList<Integer>();
	        if(root==null) {
				 return ans;
			 }
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        while(!queue.isEmpty()) {
	        	int size = queue.size();
	        	int max = -1;
	        	for(int i=0;i<size;i++) {
	        		TreeNode val = queue.poll();
	        		max = Integer.max(max, val.val);
	        		if(val.right!=null) {
	        			queue.add(val.right);
	        		}
	        		if(val.left!=null) {
	        			queue.add(val.left);
	        		}
	        	}
	        	ans.add(max);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
