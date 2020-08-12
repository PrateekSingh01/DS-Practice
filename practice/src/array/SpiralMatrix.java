package array;

public class SpiralMatrix {

	static void spiralOrder(int[][] matrix) {
		int horizontalWidth = matrix[0].length;
		int verticalWidth = matrix.length;
		int hPtr = 0, vPtr = 0,hIdx = 0,vIdx=1;
		while (hPtr != matrix[0].length / 2 && vPtr != (matrix.length) / 2) {
			while (hPtr < horizontalWidth) {
				System.out.print(matrix[vPtr][hPtr] + " ");
				hPtr++;
			}
			hPtr--;
			horizontalWidth--;
			while (vPtr < verticalWidth) {
				System.out.print(matrix[vPtr][hPtr] + " ");
				vPtr++;
			}
			vPtr--;
			verticalWidth--;
			while (hPtr >=hIdx) {
				System.out.print(matrix[vPtr][hPtr] + " ");
				hPtr--;
			}
			hPtr++;
			horizontalWidth--;
			vPtr--;

			while (vPtr >=vIdx) {
				System.out.print(matrix[vPtr][hPtr] + " ");
				vPtr--;
			}
			vPtr++;
			verticalWidth--;
			hPtr++;
			hIdx++;
			vIdx++;
		}
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 22 }, { 4, 5, 6, 23}, { 7, 8, 9, 24}, 
				{ 10, 11, 12, 25}, { 13, 14, 15, 26 } };
		spiralOrder(arr);
	}

}
