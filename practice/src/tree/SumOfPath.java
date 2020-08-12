package tree;

import java.util.List;

public class SumOfPath {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;

		}
	}
	
	static List<Integer> ans;
	static void dfs(TreeNode root,int sumTillNow, int answer,int depth) {
		if(root==null) {
			if(sumTillNow==answer) {
				for(int i=0;i<ans.size();i++) {
					System.out.print(ans.get(i)+" ");
				}
				
			}
			return;
		}
			ans.add(depth,root.val);
			dfs(root.left,sumTillNow+root.val,answer,depth+1);
			dfs(root.right, sumTillNow+root.val, answer, depth+1);
		}

	static void sumOfPaths(TreeNode root,int ans) {
		dfs(root,0,ans,0);
	}
	public static void main(String[] args) {
		

	}

}
