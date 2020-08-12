package backtracking;

public class WordSearch {

	static int vis[][];
	static boolean isSafe(int x,int y, int limx,int limy) {
		if(x<0||x>=limx||y<0||y>limy) {
			return false;
		}
		return true;
	}
	static boolean dfs(char[][]board, String word, int x, int y,int idx) {
		if(!isSafe(x,y,board.length,board[0].length)) {
			return false;
		}
		if(vis[x][y]==1) {
			return false;
		}
		if(board[x][y]==word.charAt(idx)) {
			if(idx == word.length()-1) {
				return true;
			}
			vis[x][y]=1;
			boolean ans = dfs(board,word, x+1,y,idx+1)||dfs(board,word,x,y+1,idx+1)
					||dfs(board,word,x-1,y,idx+1)||dfs(board,word,x,y-1,idx+1);
			vis[x][y]=0;
			return ans;
		}else {
			return false;
		}
	}
	 static boolean exist(char[][] board, String word) {
	        boolean ans = false;
	        if(board==null) {
	        	return false;
	        }
	        vis = new int[board.length][board[0].length];
	        for(int i=0;i<board.length;i++) {
	        	if(!ans) {
	        		for(int j=0;j<board[0].length;j++) {
	        			if(board[i][j]==word.charAt(0)) {
	        				ans = dfs(board,word,i,j,0);
	        			}
	        			if(ans==true) {
	        				break;
	        			}
	        		}
	        	}else {
	        		break;
	        	}
	        }
	        return ans;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
