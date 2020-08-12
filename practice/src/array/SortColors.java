package array;

public class SortColors {

	 static void sortColors(int[] nums) {
	        int low=0;
	        int mid =0;
	        int high= nums.length-1;
	        while(mid<high) {
	        	if(nums[mid]==0) {
	        		swap(nums,low,mid);
	        		low++;
	        		mid++;
	        	}else if(nums[mid]==1) {
	        		mid++;
	        	}else {
	        		swap(nums,mid,high);
	        		high--;
	        	}
	        }
	        for(int i=0;i<nums.length;i++) {
	        	System.out.print(nums[i]+" ");
	        }
	    }
	 static void swap(int []arr,int i,int j) {
		 int tmp=arr[j];
		 arr[j] = arr[i];
		 arr[i] = tmp;
	 }
	public static void main(String[] args) {
		int []arr = {2,0,2,1,1,0};
		sortColors(arr);
	}

}
