 package dynamicProgramming;

public class LongestIncreasingSubsequence {

	static int[] dp;

	static int max(int a, int b) {
		return a>b?a:b;
	}
	static int lis(int arr[], int idx,int prev, String v) {
		
		int ans1=0,ans2=0;
		int newPrev=prev;
		if(idx == arr.length) {
			return 0;
		}
	//	if(dp[idx]!=0) return dp[idx];
		if(prev<arr[idx]) {
			newPrev = arr[idx];
//			System.out.println(idx+"   "+newPrev+"     "+prev+"     "+v);
			ans1 = max(1+lis(arr,idx+1,newPrev,v+"a"),lis(arr,idx+1,prev,v+"b"));
			
		}else {
//			System.out.println(idx+"   "+newPrev+"     "+prev+"     "+v);
			ans2 = lis(arr,idx+1,prev,v+"b");
		}
		System.out.println(idx+"   "+newPrev+"     "+prev+"     "+v+"     "+ans1+"    "+ans2);
		dp[idx] = ans1>ans2?ans1:ans2;
		return dp[idx];
	}
	
	public static void main(String[] args) {
//		int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		int arr[] = {10,9,2,5,3,7,101,18};
//		int[] arr = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
		dp = new int[arr.length];
		System.out.println(lis(arr,0,-99999,"0"));
		System.out.println("hdfhj");
	}

}
