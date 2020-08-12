package dynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

	static int dp[][];
	static boolean isAnswer(int[]nums,int val1,int val2,int idx) {
		boolean ans = false;
		if(idx>=nums.length&&val1==val2) {
			return true;
		}
		if(idx>=nums.length&&val1!=val2) {
			return false;
		}
		if(dp[idx][val1]!=-1) {
			return dp[idx][val1]==1?true:false;
		}
		
		ans=(isAnswer(nums, val1+nums[idx], val2, idx+1)||isAnswer(nums, val1, val2+nums[idx], idx+1));
		dp[idx][val1]=ans==true?1:0;
		dp[idx][val2]=ans==true?1:0;
		return dp[idx][val1]==1?true:false;
	}
	static boolean canPartition(int[] nums) {

		
		return isAnswer(nums, 0, 0, 0);
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 5};
		dp = new int[arr.length][200000];
		for(int[] row:dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(canPartition(arr));
		System.out.println("sdsffs");
	}

}
