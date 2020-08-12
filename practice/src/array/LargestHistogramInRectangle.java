package array;

import java.util.Stack;

public class LargestHistogramInRectangle {

	static int largestRectangleArea(int[] heights) {
		int ans = -1;
		if (heights.length == 0) {
			return 0;
		}
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < heights.length; i++) {
			 if (stk.isEmpty()||heights[i] >= heights[stk.peek()]) {
				stk.push(i);
			}else {
				while (!stk.isEmpty() && heights[stk.peek()] > heights[i]) {
					int poped = stk.pop();
					if(stk.isEmpty()) {
						ans = Integer.max(ans, ((i)) * heights[poped]);
					}
					ans = Integer.max(ans, (i - poped) * heights[poped]);
				}
				stk.push(i);
			}
			
			
		}
		
		while (!stk.isEmpty()) {
			int poped = stk.pop();
			if(stk.isEmpty()) {
				ans = Integer.max(ans, ((heights.length)) * heights[poped]);
			}
			ans = Integer.max(ans, ((heights.length - poped)) * heights[poped]);

		}
		System.out.println(ans);
		return ans;
	}


	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		int[] arr1 = { 1, 2, 3, 4, 5, 3, 3, 2 };
		int arr2[] = {6, 2, 5, 4, 5, 1, 6};
		largestRectangleArea(arr2);
	}

}
