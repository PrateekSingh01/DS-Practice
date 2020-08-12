package dynamicProgramming;

public class MinimumFallingPathSum {
	static int dp[][];

	static int myMin(int a, int b, int c) {
		if (a < b && a < c) {
			return a;
		} else if (b < a && b < c) {
			return b;
		} else {
			return c;
		}
	}

	static int recursiveCall(int x, int y, int[][] A) {
		if (x == A.length) {
			return 0;
		}
		if (y < 0 || y >= A.length) {
			return Integer.MAX_VALUE;
		}
		if (dp[x][y] != 0) {
			return dp[x][y];
		}

		dp[x][y] = A[x][y]
				+ Math.min(recursiveCall(x + 1, y, A), Math.min(recursiveCall(x + 1, y + 1, A), recursiveCall(x + 1, y - 1, A)));

		return dp[x][y];
	}

	static int minFallingPathSum(int[][] A) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			dp = new int[A.length][A.length];
			min = Math.min(min, recursiveCall(0, i, A));
		}
		return min;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(A));
		System.out.println("sfsdf");

	}

}
