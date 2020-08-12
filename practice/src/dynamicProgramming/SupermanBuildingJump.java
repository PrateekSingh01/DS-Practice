package dynamicProgramming;

import java.util.Scanner;

public class SupermanBuildingJump {

	static int dp[];
	static int dph[];
	static int helper(int numOfBuilding, int height, int fallLength, int[][] building, int currHeight,
			int currBuilding) {
		if(currHeight<=0) {
			return 0;
		}
		if(dp[currHeight]!=0) {
			return dp[currHeight];
		} 
	
		int ans1 =-1;
		int ans2=-1;
		int ans3=-1;
		for(int i=0;i<numOfBuilding;i++) {
			if (i == currBuilding) {
				ans1 = building[currBuilding][currHeight]
						+ helper(numOfBuilding, height, fallLength, building, currHeight - 1, currBuilding);
			}else {
				ans3 =  building[currBuilding][currHeight]
						+ helper(numOfBuilding, height, fallLength, building, currHeight - fallLength, i);
			}
				
//			System.out.println(ans2+" "+currHeight+"b"+currBuilding);
			ans2 = Math.max(ans2, ans1);
			ans2 = Math.max(ans2, ans3);
		}
		dp[currHeight] = ans2;
		return dp[currHeight];
	}
	
	static int jump(int numOfBuilding, int height, int fallLength,int[][] building) {
		int ans =-1;
		for(int i=0;i<numOfBuilding;i++) {
			System.out.println(helper(numOfBuilding,height,fallLength,building,height-1,i));;
		}
		//System.out.println(helper(numOfBuilding,height,fallLength,building,height-1,numOfBuilding-1));
		return ans;
	}
	public static void main(String[] args) {
		
		 int numOfBuilding =4; int height = 15; int fallLength = 2;
		 dp = new int[height];
		 dph = new int[height];
		 int dummy[][]= {{5 ,1 ,1, 1, 4 ,10}, {8 ,9 ,5, 7,7 ,3 ,9 ,8 ,8}, {5 ,9 ,5 ,6 ,4 ,3}};
		 
//		 Scanner in = new Scanner(System.in);
//	        int numOfBuilding = in.nextInt();
//	        int height = in.nextInt();
//	        int fallLength = in.nextInt();
//	        dp = new int[height];
//	        int[][] dummy = new int[numOfBuilding][height+1];
//	        for(int i=0;i<numOfBuilding;i++){
//	        	int numIter = in.nextInt();
//	        	dummy[i][0]=numIter;
//	            for(int j=1;j<=numIter;j++){
//	                dummy[i][j] = in.nextInt();
//	            }
//	        }
		int[][] building = new int[numOfBuilding][height+1];
		for(int i=0;i<dummy.length;i++) {
			for(int j=1;j<=dummy[i][0];j++) {
				building[i][dummy[i][j]]++;
			}
		}
		jump(numOfBuilding,height,fallLength,building);
		System.out.println("dfdf");
	}

}
