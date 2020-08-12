package array;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {

		int num = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 1 || nums[i] > num) {
				nums[i] = num + 1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]);
			if(val<num) {
				
				nums[val] *= -1;
			}

		}
		int ans = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] < num + 1) {
				ans = i;
				break;
			}
		}
		return ans == -1 ? nums.length : ans;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 0 };
		firstMissingPositive(arr);
	}

}
