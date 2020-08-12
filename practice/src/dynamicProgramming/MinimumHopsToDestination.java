package dynamicProgramming;

public class MinimumHopsToDestination {

	static int dp[];
	static int minimumHops(int[] a,int dest,int idx) {
		if(dp[idx]!=0) {
			 return dp[idx];
		}
		int myAns = 999999;
		if(idx == dest) {
			return 0;
		}
		else if(idx>= dest||a[idx]==0) {
			return 999999;
		}
		for(int i=1;i<=a[idx];i++) {
			if(idx+i<=dest)
			{
				int ans = 1+minimumHops(a, dest, idx+i);
				myAns = ans>myAns?myAns:ans;
			}
			dp[idx] = myAns;
			
		}
		return (dp[idx]);
	}
	public static void main(String[] args) {
		int arr[] = {5,9,3,2,1,0,2,3,3,1,0,0};
		dp = new int[arr.length];
		System.out.println(minimumHops(arr,arr.length-1,0));
	}

}
