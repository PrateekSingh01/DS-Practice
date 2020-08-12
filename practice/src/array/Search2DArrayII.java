package array;

public class Search2DArrayII {

	
	 static boolean searchMatrix(int[][] matrix, int target) {
	        boolean ans = false;
	       int j=matrix[0].length-1;
	       int i = 0;
	       while(i<matrix[0].length&&j>=0) {
	    	   if(matrix[i][j]==target) {
	    		   ans=true;
	    		   break;
	    	   }
	    	   if(j>=0&&target>matrix[i][j]) {
	    		   i++;
	    	   }
	    	   if(i<matrix[0].length&&target<matrix[i][j]) {
	    		   j--;
	    	   }
	       }
	        return ans;
	    }
	public static void main(String[] args) {
		int arr[][] = {{1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(arr, 41));
	}

}
