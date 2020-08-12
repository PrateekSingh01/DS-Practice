package array;

public class MinimumSIzeSubarraySum {

	static public int minSubArrayLen(int s, int[] nums) {
		int p1=0,p2=0;
		int ans=Integer.MAX_VALUE;
		int[] sumArray = new int[nums.length];
		sumArray[0] = nums[0];
		for(int i=1;i<nums.length;i++) {
			sumArray[i] = sumArray[i-1]+nums[i];
		}
		while(p1<nums.length&&p2<nums.length) {
			int currSum = sumArray[p2]-sumArray[p1]+nums[p1];
			if(currSum>=s) {
				ans=ans>p2-p1?p2-p1:ans;
				System.out.println(p2+"     "+p1);
				p1++;
			}else {
				p2++;
			}
		}
		if(ans==Integer.MAX_VALUE) {
			return 0;
		}else {
			return ans+1;
		}
	}

	public static void main(String[] args) {
		int arr[]= {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(99, arr));
		System.out.println("dddd");

	}

}
