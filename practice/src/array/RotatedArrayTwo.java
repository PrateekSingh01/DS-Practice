package array;

public class RotatedArrayTwo {

	static boolean customBnarySearch(int[] arr, int target, int l, int r) {
		boolean ans = false;
		int mid = (l + r) / 2;
		if (l > r) {
			return false;
		}
		if (arr[mid] == target || (arr[l] == arr[r] && arr[l] == target)) {
			return true;
		} else if (arr[l] < target && arr[mid] > target) {
			ans = customBnarySearch(arr, target, l, mid);
		} else {
			ans = customBnarySearch(arr, target, mid + 1, r);
		}
		return ans;
	}

	public boolean search(int[] nums, int target) {

		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 5, 6, 0, 0, 1, 2 };
		System.out.println(customBnarySearch(arr, 7, 0, arr.length - 1));
		System.out.println('s');
	}

}
