package array;

public class MinimumPathSum {
	static int[][] dp;

	static int dfs(int[][] grid, int x, int y, int minCost) {

		System.out.println(x + "   " + y);
		if (x == grid.length - 1 && y == grid[0].length - 1) {
			return grid[x][y];
		}
		if (x > grid.length - 1 || y > grid[0].length - 1) {
			return 100000;
		}
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		dp[x][y] = grid[x][y] + Math.min(dfs(grid, x + 1, y, minCost), dfs(grid, x, y + 1, minCost));
		return dp[x][y];
	}

	public int minPathSum(int[][] grid) {

		return -1;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		dp = new int[arr.length][arr[0].length];

		System.out.println(dfs(arr, 0, 0, 999999));
		System.out.println("chdh");
	}

}
