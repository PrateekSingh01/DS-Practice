package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	static List<List<Integer>> ans;
	static int[] used;
	static void permutation(int[] nums, int curr, ArrayList<Integer> val) {
		if(curr==nums.length) {
			List<Integer>v = new ArrayList<Integer>(val);
			if(!ans.contains(val)) {
				ans.add(v);
			}
			
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(used[i]==1) continue;
			used[i] =1;
			val.add(curr, nums[i]);
			
			permutation(nums, curr+1, val);
			used[i]=0;
			val.remove(curr);
//			val = new ArrayList<Integer>();
		}
	}
	 public static List<List<Integer>> permute(int[] nums) {
	        ans = new ArrayList<List<Integer>>();
	        used = new int[nums.length];
	        permutation(nums, 0, new ArrayList<Integer>());
	        return ans;
	    }
	public static void main(String[] args) {
		int[] arr = {1,1,2};
		permute(arr);

	}

}
