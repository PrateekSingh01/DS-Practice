/*
 * TO DO BETTER IMPLEMENTATION
 */

package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

	static List<Integer> answer = new ArrayList<>();
	static int[] visited;
	static int isCycle;
	static Map<Integer, List<Integer>> adjList;

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		answer = new ArrayList<>();
		visited = new int[numCourses];
		adjList = new HashMap<>();
		isCycle = 0;
		for (int i = 0; i < prerequisites.length; i++) {
			int src = prerequisites[i][1];
			int dest = prerequisites[i][0];
			List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
			list.add(dest);
			adjList.put(src, list);
		}
		for (int i = 0; i < numCourses; i++) {

			if (visited[i] == 0) {
				int[] visiting = new int[visited.length];
				dfs(i, visiting);
			}
		}

		int[] arr = new int[0];
		if (isCycle == 0) {
			arr = new int[answer.size()];
			for (int i = 0; i < answer.size(); i++)
				arr[answer.size() - 1 - i] = answer.get(i);
		}
		return arr;
	}

	static void dfs(int node, int[] visiting) {
		visited[node] = 1;
		List<Integer> adjacencyList = adjList.get(node);
		visiting[node] = 1;
		if (adjacencyList != null) {
			for (int edge : adjacencyList) {
				if (visited[edge] != 1) {
					dfs(edge, visiting);
				} else if (visiting[edge] == 1) {
					isCycle = 1;
				}
			}
		}
		visiting[node] = 0;
		answer.add(node);
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 0 }, { 0, 1 }, { 3, 1 }, { 3, 2 } };

		int[] ans = findOrder(4, arr);
		for (int x : ans) {
			System.out.print(x + " ");
		}
		System.out.println("sdsd");
	}

}
