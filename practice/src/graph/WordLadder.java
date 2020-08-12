package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordLadder {

	static Map<String, Set<String>> adjList;
	static List<String> visited;

	static void preProcess(List<String> wordList, String beginWord) {
		Set<String> modWordList = new HashSet<String>(wordList);
		modWordList.add(beginWord);
		for (String word : modWordList) {
			char[] wordArr = word.toCharArray();
			for (int i = 0; i < wordArr.length; i++) {
				char[] tmp = Arrays.copyOf(wordArr, wordArr.length);

				for (int j = 0; j < 26; j++) {
					tmp[i] = (char) ('a' + j);
					if (modWordList.contains(String.valueOf(tmp)) && !word.equals(String.valueOf(tmp))) {
						Set<String> dst = adjList.getOrDefault(word, new HashSet<String>());
						dst.add(String.valueOf(tmp));
						adjList.put(word, dst);
					}
				}
			}
		}
	}

	static public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		adjList = new HashMap<String, Set<String>>();
		visited = new ArrayList<String>();
		preProcess(wordList, beginWord);
		if (wordList.size() == 0 || wordList == null) {
			return 0;
		}
		if (!wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int distance = 0;
		boolean found = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				if (!visited.contains(word)) {
					if (word.equals(endWord)) {
						found = true;
						break;
					}
					Set<String> adjacency = adjList.get(word);
					if (adjacency != null) {
						queue.addAll(adjacency);
					}

					visited.add(word);
				}
			}
			distance++;
			if (found || queue.isEmpty()) {
				break;
			}
		}
		if (!found) {
			distance = 0;
		}
		return distance;
	}

	public static void main(String[] args) {
		List<String> wordList = Stream.of("hot", "dot", "tog", "cog").collect(Collectors.toList());
		String beginWord = "hit";
		String endWord = "cog";
		System.out.println(ladderLength(beginWord, endWord, wordList));

	}

}