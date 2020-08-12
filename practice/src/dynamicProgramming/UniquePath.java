package dynamicProgramming;

public class UniquePath {
	static int dp[][];
	static int helper(int m,int n,int x,int y) {

		if(x>=m||y>=n) {
			return 0;
		}
		if(x==m-1||y==n-1) {
			return 1;
		}
		if(dp[x][y]!=0) {
			return dp[x][y];
		}
		dp[x][y] = helper(m,n,x+1,y)+helper(m,n,x,y+1);
		return dp[x][y];
	}
	 static int uniquePaths(int m, int n) {
		 dp = new int[m][n];
	     System.out.println(helper(m,n,0,0));
		 return -1;
	    }
	public static void main(String[] args) {
		uniquePaths(7,3);

	}

}
