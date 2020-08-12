package slidingWindow;

public class MaxConsecutiveOnes3 {

	 public static int longestOnes(int[] A, int K) {
	        int ans=0;
	        if(A==null) {
	        	return ans;
	        }
	        else if(A.length==1) {
	        	if(K>0) {
	        		return 1;
	        	}else {
	        		return 0;
	        	}
	        }
	        int st=0,end=0;
	        while(end<A.length) {
	        	if(A[end]==0) {
	        		//check if k can be -ve
	        		K--;
	        	}
	        	
	        	while(K<0) {
	        		ans = Integer.max(ans, end-st);
	        		if(A[st]==0) {
	        			K++;
	        		}
	        		st++;
	        	}
	        	end++;
	        }
	        ans = Integer.max(ans, end-st);
	        return ans;
	    }
	public static void main(String[] args) {
		int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
		System.out.println(longestOnes(arr, 2));

	}

}
