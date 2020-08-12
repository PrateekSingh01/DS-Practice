package dynamicProgramming;

public class MaximalSquare {
	static int maxSize;
	static int lookup[][];
	static int helper(char arr[][], int x, int y) {
		if (x >= arr.length || y >= arr[0].length || arr[x][y] == 0) {
			return 0;
		}
		if (lookup[x][y] != 0) {
			return lookup[x][y];
		}

		if (arr[x][y] != 0) {
			lookup[x][y] = arr[x][y]
					+ Integer.min(helper(arr, x, y + 1), Integer.min(helper(arr, x + 1, y), helper(arr, x + 1, y + 1)));
		}
		if (lookup[x][y] > maxSize) {
			maxSize = lookup[x][y];
		}

		return lookup[x][y];
	}

	static int maximalSquare(char[][] matrix) {
		
		maxSize = -1;
		lookup = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					helper(matrix, i, j);
				}
			}
		}
		return maxSize * maxSize;
	}

	public static void main(String[] args) {
		char arr[][] = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
		maximalSquare(arr);
	}

}
