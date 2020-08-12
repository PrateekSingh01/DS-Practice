package dynamicProgramming;

import java.util.Map;

public class LongestPalindromicSubstring {

	static Map<String, String> lookup;
	static String dp[][];
	static String aux[][];

	static boolean checkPalindrome(String s, int st, int end) {
		int l = end - st;
		int j = 0;
		for (int i = st; i < st + (l); i++) {
			if (s.charAt(i) == s.charAt(end - j)) {
				j++;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	
	static String palindromeCheckerArr(String s, int st, int end) {

		if (st == end) {
			return s.charAt(st) + "";
		}
		if (st >= s.length() || end < 0) {
			return null;
		}
		if (dp[st][end] != null) {
			return dp[st][end];
		} else {
			if (checkPalindrome(s, st, end)) {
				
				dp[st][end] = s.substring(st, end + 1);
				return dp[st][end];

			}
			String s1 = palindromeCheckerArr(s, st + 1, end);
			String s2 = palindromeCheckerArr(s, st, end - 1);
			dp[st][end] = s1.length() > s2.length() ? s1 : s2;
			return dp[st][end];
		}

	}

	public static void main(String[] args) {
		String s = "palindromeCheckerArr";

		long startTime = System.nanoTime();
		dp = new String[s.length()][s.length()];
		System.out.println(palindromeCheckerArr(s, 0, s.length() - 1));
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println(duration / 1000000);

	}

}
