package array;

public class RotateImage {

	public static void rotate(int[][] arr) {
		int tmp=0;
		int n = arr.length;
		for(int i=0;i<n/2;i++) {
			for(int j=i;j<n-i-1;j++) {
				tmp = arr[i][j];
				arr[i][j] = arr[j][n-i-1];
				arr[j][n-i-1] = arr[n-i-1][n-j-1];
				arr[n-i-1][n-j-1] = arr[n-j-1][i];
				arr[n-j-1][i] = tmp;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
//		int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate(arr);
		System.out.println();
		rotate(arr);
		System.out.println();
		rotate(arr);
	}

}
