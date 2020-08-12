package array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	static int ans[];

	static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> dq = new LinkedList<>();
		int j = 0;
		for (int i = 0; i < nums.length; i++) {

			
			while (!dq.isEmpty() && dq.peek() < i - k + 1) {
				dq.poll();
			}

			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}

			dq.add(i);
			if(i>=k-1) {
				
				ans[j++]=nums[dq.peek()];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k=3;
		ans = new int[nums.length-k];
		maxSlidingWindow(nums, k);

	}

}
