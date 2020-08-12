package slidingWindow;

public class PermutationInString {
	static int[] s1Count;
	static int[] window;

	public static boolean checker() {
		for(int i=0;i<26;i++) {
			if(s1Count[i]!=window[i]) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkInclusion(String s1, String s2) {
		s1Count = new int[26];
		window = new int[26];
		if(s2.length()<s1.length()) {
			return false;
		}
		for(int i=0;i<s1.length();i++) {
			s1Count[s1.charAt(i)-'a']++;
			window[s2.charAt(i)-'a']++;
		}
		if(checker()) {
			return true;
		}
		for(int i=0;i<s2.length()-s1.length();i++) {
			window[s2.charAt(i)-'a']--;
			window[s2.charAt(s1.length()+i)-'a']++;
			if(checker()) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String s1 = "adc";
		String s2 = "dcda";
		System.out.println(checkInclusion(s1, s2));

	}

}
