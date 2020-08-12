package array;

public class MostWater {

	static int min(int a, int b) {
		return a<b?a:b;
	}
	
	static int max(int a, int b) {
		return a>b?a:b;
	}
	
	static public int maxArea(int[] height) {
		int max =-99;
        for(int i=0;i<height.length;i++) {
        	for(int j=0;j<height.length;j++) {
        		int val = min(height[i],height[j])*Math.abs(i-j);
        		max = max(val,max);
        	}
        }
		return max;
    }
	public static void main(String[] args) {
		int arr[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));

	}

}
