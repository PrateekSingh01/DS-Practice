package array;

public class PartitionArrayIntoDisjointSet {

	public static int partitionDisjoint(int[] A) {
		int ans=0;
		int maxArry[] = new int[A.length];
		int minArray[] = new int[A.length];
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++) {
			if(A[i]>maxVal) {
				maxVal=A[i];
				
			}
			maxArry[i] =maxVal;
		}
		for(int i=A.length-1;i>0;i--) {
			if(A[i]<minVal) {
				minVal=A[i];
				
			}
			minArray[i]=minVal;
		}
		for(int i=0;i<A.length;i++) {
			if (maxArry[i-1] <= minArray[i])
                return i;
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {32,57,24,19,0,24,49,67,87,87};
		System.out.println(partitionDisjoint(arr));
		System.out.println("ssfsif");

	}

}
