package array;

public class RainWater {

	static int trap(int[] height) {
		int res = 0;
		int leftMax[] = new int[height.length];
		int rightMax[] = new int[height.length];
		int val = -1;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > val) {
				val = height[i];

			}
			leftMax[i] = val;
		}
		val = -1;
		for (int i = height.length - 1; i > -1; i--) {
			if (height[i] > val) {
				val = height[i];

			}
			rightMax[i] = val;
		}

		for (int i = 0; i < height.length; i++) {
			res += Integer.min(leftMax[i], rightMax[i]) - height[i];
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		trap(arr);
	}

}
