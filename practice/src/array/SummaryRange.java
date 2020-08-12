package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SummaryRange {

	static public List<String> summaryRanges(int[] nums) {
		List<String> ans= new ArrayList<>();
		int continuation=0;
		String s = null;
		for(int i=0;i<nums.length-1;i++) {
			
			if(nums[i+1]==nums[i]+1) {
				if(continuation==1) {
					continue;
				}
				if(continuation==0) {
					s=new String();
					continuation=1;
					s=Integer.toString(nums[i]);
				}
				
				
			}else {
				if(continuation==0) {
					s=new String();
					s=Integer.toString(nums[i]);
				}
				else {
					continuation=0;
					s=s+"->"+Integer.toString(nums[i]);
				}
				
			}
			if(continuation==0) {
				ans.add(s);
			}
		}
		if(continuation==1) {
			s=s+"->"+Integer.toString(nums[nums.length-1]);
			ans.add(s);
		}else {
			s=new String();
			s=Integer.toString(nums[nums.length-1]);
			ans.add(s);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {0,2,3,4,6,8,9};

		List<String> ans = summaryRanges(arr);
		Iterator itr = ans.iterator();
		while(itr.hasNext()) {
			Object element = itr.next();
			System.out.println(element);
		}
	}

}
