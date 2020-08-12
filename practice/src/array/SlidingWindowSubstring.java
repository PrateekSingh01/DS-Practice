package array;

public class SlidingWindowSubstring {

	static int map[];

	static String minWindow(String s, String t) {
		int counter = 0;
		for (int i = 0; i < t.length(); i++) {
			if (map[t.charAt(i)] == 0) {
				counter++;
			}
			map[t.charAt(i)]++;

		}
		String ans = "";
		int end = 0, begin = 0, len = 99999999;
		while (end < s.length()) {
			if (t.indexOf(s.charAt(end)) != -1) {
				map[s.charAt(end)]--;
				if (map[s.charAt(end)] == 0) {
					counter--;
				}

			}

			end++;
		
			while (counter == 0) {
				if( end-begin<=len) {
	    			 len = end-begin;
	    			 ans = s.substring(begin, end); 
	    		 }
				if (t.indexOf(s.charAt(begin)) != -1) {
					map[s.charAt(begin)]++;
					if (map[s.charAt(begin)] > 0) {
						counter++;
					}

				}

				begin++;
			}
			
		}
		return ans;
	}

	public static void main(String[] args) {
		map = new int[128];
		System.out.println(minWindow("adobecodebanc", "abc"));

	}

}
