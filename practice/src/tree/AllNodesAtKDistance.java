package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesAtKDistance {

	static class TreeNode {
		int val;
		TreeNode right = null;
		TreeNode left = null;

		TreeNode(int x) {
			val = x;
		}
	}
	static Map<TreeNode,Integer> depth = new HashMap<>();
	static void mapper(TreeNode curr) {
		if(curr==null) return;
		depth.put(curr, 999999);
		mapper(curr.left);
		mapper(curr.right);
	}
	static boolean marker(TreeNode curr, int target) {
		if (curr == null) {
			return false;
		}
		if (curr.val == target) {
			depth.replace(curr, 0);
			return true;
		}
		boolean parentOfTarget = marker(curr.left, target) || marker(curr.right, target);
		if (parentOfTarget) {
			int leftval = depth.get(curr.left)!=null?depth.get(curr.left):999999;
			int rightval =depth.get(curr.right)!=null?depth.get(curr.right):999999;
			depth.replace(curr, Integer.min(leftval, rightval)-1);
		}
		return parentOfTarget;

	}

	static List<Integer> findAtDistanceFromCurrent(TreeNode curr, int currD, int targetD, List<Integer> pathList) {
		if (currD == targetD) {
			pathList.add(curr.val);
			return pathList;
		}
		if (curr.left == null && curr.right == null) {
			return pathList;
		}
		
		if (curr.left !=null &&depth.get(curr.left) == 999999) {
			List<Integer> currPath = new ArrayList<Integer>();
			pathList.addAll(findAtDistanceFromCurrent(curr.left, currD + 1, targetD, currPath));
		}
		if (curr.right !=null &&depth.get(curr.right) == 999999) {
			List<Integer> currPath = new ArrayList<Integer>();
			pathList.addAll(findAtDistanceFromCurrent(curr.right, currD + 1, targetD, currPath));
		}
		return pathList;
	}

	static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		mapper(root);
		List<Integer> atDistanceK = new ArrayList<Integer>();
		marker(root, target.val);
		TreeNode curr = root;
		while(depth.get(curr)!=999999) {
			List<Integer> atDistance = new ArrayList<Integer>();
			atDistanceK.addAll(findAtDistanceFromCurrent(curr, 0, depth.get(curr)+K, atDistance));
//			if(atDistanceK.size()==0) {
//				break;
//			}
			if(curr!=null){
                if(curr.left!=null &&depth.get(curr.left)<=0) {
				curr = curr.left;
			}else if(curr.right!=null) {
				curr = curr.right;
			}
			else{
                break;
            }
            }else{
                break;
            }
		}
		System.out.println("wrefdgf");
		return atDistanceK;
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

//		l3.left = l5;
//		l3.right = l1;
//		l5.left = l6;
//		l5.right = l2;
//		l2.left = l7;
//		l2.right = l4;
//		l1.left = l0;
//		l1.right = l8;
		
		
		l0.right=l1;
		l1.right=l2;
		l2.right=l3;
		distanceK( l1, l1, 2);
		System.out.println("dsds");
	}

}
