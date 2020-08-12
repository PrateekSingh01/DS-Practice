package graph;

import java.util.ArrayList;
import java.util.List;

class test {
    static List<Integer> answer = new ArrayList<>();
	static int[] visited ;
	public static boolean canFinish(int numCourses, int[][] prerequisites,int[] visited,int i) {
		for(int k=0;k<prerequisites.length;k++) {
			if(prerequisites[i][k]==1&&visited[k]==0) {
				visited[k]=1;
				canFinish(numCourses, prerequisites, visited, k);
				answer.add(k);
			}
		}
		return false;
	}
    public int[] findOrder(int numCourses) {
        int[] myans = new int[numCourses];
         numCourses = 2;
         int prerequisites[][]= {{0,1}};
        visited = new int[numCourses];
        if(prerequisites.length==0){
            for(int i=0;i<numCourses;i++){
                myans[i]=i;
            }
            return myans;
        }
        int a1[][] = new int[numCourses][numCourses];
		for(int[]arrs:prerequisites) {
			a1[arrs[1]][arrs[0]] = 1;
		}
		//answer.add(0);
		for(int i =0;i<numCourses;i++) {
			for(int j=0;j<numCourses;j++) {
				if(a1[i][j]==1&& visited[i]==0) {
                    visited[i]=1;
					canFinish(numCourses, a1, visited, i);
					answer.add(i);
				}
			}
		}
		int[] ans1 = new int[answer.size()];
        int i=0;
		
		for(Integer ans:answer) {
			ans1[i] = ans;
			i++;
		}
        for(int j=0;j<myans.length/2;j++) {
			int temp = ans1[j];
			ans1[j] = ans1[ans1.length - 1 - j];
			ans1[ans1.length - 1 - j] = temp;
		}
        return ans1;
    }
}