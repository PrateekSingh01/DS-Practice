package backtracking;

public class PathSumIII {

	static int counter;
	static int dfs(int[][]grid, int i, int j,int [][] vis,int count) {
		int ans=0;
		
		if(i<0||i>grid.length-1||j<0||j>grid[0].length-1) {
			return 0;
		}
		
		if(vis[i][j]==1) {
			return 0;
		}
		
		if(grid[i][j]==2) {
			if(count-1==counter) {
				return 1;
			}
			else {
				return 0;
			}
		}
		if(grid[i][j]==-1) {
			return 0;
		}
		else {
			vis[i][j]=1;
			ans = dfs(grid, i+1, j,vis,count+1)+dfs(grid,i-1,j,vis,count+1)+dfs(grid, i, j+1,vis,count+1)+dfs(grid, i, j-1,vis,count+1);
			vis[i][j]=0;
		}
		return ans;
	}
	 static int uniquePathsIII(int[][] grid) {
		 if(grid[0].length==0) {
			 return 0;
		 }
		 int[][] vis = new int[grid.length][grid[0].length];
		 int ans=-1;
		 int x=-1,y=-1;
		 counter=0;
		 for(int i=0;i<grid.length;i++) {
			 for(int j=0;j < grid[0].length;j++) {
				 if(grid[i][j]==1) {
					 x=i;y=j;
				 }
				 if(grid[i][j]==0) {
					 counter++;
				 }
			 }
		 } 
		 ans = dfs(grid, x, y, vis, 0);
		 System.out.println(ans);
		 return ans;
	    }
	public static void main(String[] args) {
		int arr[][]={{1,0,0,0},{0,0,0,0},{0,0,0,2}};
		uniquePathsIII(arr);
	}

}
