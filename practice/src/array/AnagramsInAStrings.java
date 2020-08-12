package array;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInAStrings {

	static int map[];

	static List<Integer> findAnagrams(String s, String p) {
		map = new int[27];
		int counter = 0;
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			map[c - 'a']++;
			counter++;
		}
		List<Integer> ans = new ArrayList<>();
		int st = 0, end = 0;
		while (end < s.length()) {
			if (map[s.charAt(end) - 'a'] == 0) {
				if(p.indexOf(s.charAt(st))==-1) {
					st++;
				}else {
					while (st != end) {
						if(p.indexOf(s.charAt(st))>=0) {
							map[s.charAt(st) - 'a']++;
							counter++;
						}
						st++;
						
					}
				}
				
			}
			if (map[s.charAt(end) - 'a'] > 0) {
				counter--;
				map[s.charAt(end) - 'a']--;
				if (counter == 0) {
					ans.add(st);
				}
			}

			if (counter == 0) {
				while (st <= end) {
					map[s.charAt(st) - 'a']++;
					counter++;
					st++;
					
				}
				
			}
			end++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "BACDGABCDA".toLowerCase(), p = "ABCD".toLowerCase();
		findAnagrams(s, p);

	}

}
