package dynamicProgramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordBreak {
	boolean ans = false;
	int lookup[];
	static boolean helper(String s, List<String> wordDict, int idx, String currWord, int wordCount) {

		if (idx == s.length()) {
			if (wordDict.contains(currWord)) {
				return true;
			} else {
				
				return false;
			}
		}
		boolean c1 = false, c2 = false, c3;
		if (wordDict.contains(currWord)) {
			c1 = helper(s, wordDict, idx + 1, s.charAt(idx) + "", wordCount + 1);

		}
		c2 = helper(s, wordDict, idx + 1, currWord + s.charAt(idx), wordCount);
		return c1 || c2;
	}

	static boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict.isEmpty()) {
			return false;
		}
		
		System.out.println(helper(s, wordDict, 0, "", 0));
		return (helper(s, wordDict, 0, "", 0));
	}

	public static void main(String[] args) {
		List<String> wordDict = Stream.of(
				"aa","aaaa").collect(Collectors.toList());
		wordBreak("aaaaaaa", wordDict);

	}

}
