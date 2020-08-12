package dynamicProgramming;

public class PerfectSquares {

	static int min = 999999;
	static int[] dp;
	static int helper(int currVal,int counter,int n) {
		int ans =999999;
		int myans = 999999;
		if(currVal==0) {
			return 0;
		}
		if(currVal<0) {
			return 999999;
		}
		if(dp[currVal]!=0) {
			return dp[currVal]; 
		}
		for(int i=1;i<=Math.sqrt(n);i++) {
			ans =1+ helper(currVal-i*i, counter+1, n);
			myans = Integer.min(ans, myans);
		}
		
		dp[currVal]=myans;
		return dp[currVal];
	}
	public static void main(String[] args) {
		int n=7198;
		dp = new int[n+1];
		System.out.println(helper(n,0,n));

	}

}
