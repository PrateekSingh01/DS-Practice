package dynamicProgramming;

public class LongestPalindrome {

	static int max(int x, int y) {
		int ans = x>y?x:y;
		return ans;
	}
	static int dp[][] = new int[5][5];
	static int longestPalindrome(String x,int l, int r) {
		//int ans = 0;
		if(dp[l][r]!=0) return dp[l][r];
		if(l>r) return 0;
		if(l==r) return 1;
		if(x.charAt(l) == x.charAt(r)) {
			dp[l][r] = 2+longestPalindrome(x, l+1, r-1);
		}
		else {
			dp[l][r] = max(longestPalindrome(x, l+1, r),longestPalindrome(x, l, r-1));
		}
		return dp[l][r];
	}
	public static void main(String[] args) {
		String x ="babad";
		System.out.println(longestPalindrome(x, 0, x.length()-1));
		System.out.println("sd");
	}

}
