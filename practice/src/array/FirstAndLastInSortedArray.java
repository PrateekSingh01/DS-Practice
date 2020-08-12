package array;

public class FirstAndLastInSortedArray {

	static int lower=9999991;
	static int higher=-1;
	static void searchRange(int[] nums, int target, int low, int high) {
		int mid = (high+low)/2;
		if(low==high) {
			if(mid>higher ) {
				higher=mid;
			}
			if(mid<lower) {
				lower=mid;
			}
		}
		if(low>=high) {
			return;
		}
		
		if(nums[mid]==target) {
			if(mid>higher ) {
				higher=mid;
			}
			if(mid<lower) {
				lower=mid;
			}
			searchRange(nums, target, low, mid);
			searchRange(nums, target, mid+1, high);
		}else if(nums[mid]>target) {
			searchRange(nums, target, low, mid);
		}else {
			searchRange(nums, target, mid+1, high);
		}
	}

	public static void main(String[] args) {
//		
//		int[] arr = {5,7,8,8,10};
//		searchRange(arr, 7, 0, arr.length-1);
//		int arr1[] ={lower,higher};
//		System.out.println(lower+"  "+higher);
		throw new ArrayIndexOutOfBoundsException("null");
	}

}
