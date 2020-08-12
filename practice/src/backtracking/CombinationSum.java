package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	static List<List<Integer>> ans;
	
	 public static void helper(int[] candidates, List<Integer> list, int target, int currSum,int idx) {
		 if(currSum==target) {
			 List<Integer> dummy = new ArrayList<Integer>(list);
			 Collections.sort(dummy);
			 if(!ans.contains(dummy)){
                 ans.add(new ArrayList<Integer>(dummy));
            }
			
			 return;
		 }
		
		 if(currSum>target) {
			 return;
		 }
		 for(int i=0;i<candidates.length;i++) {
			 list.add(idx, candidates[i]);
			 helper(candidates, list, target, currSum+candidates[i], idx+1);
			 list.remove(idx);
		 }
	 }
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	     ans = new ArrayList<List<Integer>>();   
		 helper(candidates, new ArrayList<Integer>(), target, 0, 0);
		 return ans;
	    }
	public static void main(String[] args) {
		int[] arr = {2,3,6,7};
		combinationSum(arr, 7);
	}

}
