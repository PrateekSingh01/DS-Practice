package array;

public class NextPermutation {

	 static void nextPermutation(int[] nums) {
		 	boolean swapped = false;
	        for(int i=nums.length-1;i>0;i--) {
	        	int j=i-1;
	        	while(j>=0) {
	        		if(nums[j]<nums[i]) {
	        			swapped = true;
	        			swap(nums,i,j);
	        			break;
	        		}
	        		j--;
	        	}
	        	if(swapped) {
	        		reverse(nums, j+1, i);
	        		break;
	        	}
	        	
	        }
	        
	        if(!swapped) {
	        	for(int i=0;i<nums.length/2;i++) {
	        		swap(nums,i,nums.length-1-i);
	        	}
	        }
	        for(int i=0;i<nums.length;i++) {
        		System.out.print(nums[i]+" ");
        	}
	    }
	 
	 static void reverse(int [] nums,int st,int j) {
		   int i = st;
	        while (i < j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	 }
	 static void swap(int []arr,int i,int j) {
		 int tmp=arr[j];
		 arr[j] = arr[i];
		 arr[i] = tmp;
	 }
	public static void main(String[] args) {
		int arr[]= {1,3,2};
		nextPermutation(arr);		

	}

}
