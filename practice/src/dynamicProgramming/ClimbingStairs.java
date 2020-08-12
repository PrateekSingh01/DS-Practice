package dynamicProgramming;

public class ClimbingStairs {

	 static int array[] = new int[10000];
	static int findWays(int stepsToGo) {
			if(stepsToGo<0) return 0;
			if(stepsToGo==0) return 1;
			if(array[stepsToGo]!=0) return array[stepsToGo];
		
		array[stepsToGo] = findWays(stepsToGo-1)+findWays(stepsToGo-2);
		return array[stepsToGo];
	}
	public static void main(String[] args) {
		int steps = 44;
		int ans = findWays(steps);
		System.out.println(ans);

	}

}
