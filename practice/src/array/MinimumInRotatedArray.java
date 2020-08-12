package array;

public class MinimumInRotatedArray {
	static int findMin(int[] nums,int l,int r) {
		int ans=-1;
		int mid=(l+r)/2;
		if(l>r) {
			return ans;
		}
		if((mid!=0&&mid!=nums.length-1) && nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]) {
			return mid;
		}else if(mid==0&&nums[1]<nums[0]) {
			return 0;
		}else if(mid==nums.length-1&&nums[nums.length-1]>nums[mid-1]&& nums[nums.length-1]>nums[0]) {
			return mid;
		}
		if(nums[mid]<nums[r]) {
			return findMin(nums, l, mid);
		}else {
			return findMin(nums, mid+1, r);
		}
		
	}

	public static void main(String[] args) {
		int arr[] = {4,5,1,2,3};
		int ans = findMin(arr,0,arr.length-1);
		System.out.println(ans+1%arr.length);
		
		System.out.println("dsdsd");

	}

}
