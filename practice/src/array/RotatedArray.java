package array;

public class RotatedArray {

	static int findPivot(int arr[], int l, int r) {
		int mid = (l+r)/2;
		int ans =-1;
		if(mid==l||mid==r) {
			return arr[l]>arr[r]?r:l;
		}
		if(l>r) {
			return -1;
		}
		
		else
		if(arr[mid]<arr[r]&arr[mid]<arr[r]) {
			// System.out.println(mid+"      "+arr[mid]);
			return mid;
		}else {
			if(arr[l]<arr[mid]) {
				 ans = findPivot(arr, mid, r);
			}else {
				
				ans =  findPivot(arr, l, mid);
			}
		}
		return ans;
	}
	
	static int binarySearch(int arr[],int l, int r, int word) {
		int mid=(l+r)/2;
		int ans = -1; 
		if(l>r) {
			return -1;
		}
		if(arr[mid]==word) {
			return mid;
		}
		if(arr[mid]>word) {
			ans = binarySearch(arr, l, mid-1, word);
		}else {
			ans = binarySearch(arr, mid+1, r, word);
		}
		
		
		return ans;
	}
	public static void main(String[] args) {
		int arr[] = {5,1,2,3,4};
		int pvt = findPivot(arr, 0, arr.length-1);
		int word =1;
		if(pvt<=0) {
			System.out.println(binarySearch(arr, 0, arr.length-1, word));
		}else {
			int leftAns = binarySearch(arr, 0, pvt-1, word);
			int rightAns = binarySearch(arr, pvt, arr.length-1, word);
			System.out.println(leftAns>rightAns? leftAns:rightAns);
		}
		System.out.println();
	}

}
