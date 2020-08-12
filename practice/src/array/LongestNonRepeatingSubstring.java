package array;

public class LongestNonRepeatingSubstring {

	static boolean checkSubstr(int st, int en, char[] word) {
		int map[] = new int[27];
		for(int i=st;i<=en;i++) {
			if(map[word[i]-'a']==0) {
				map[word[i]-'a']++;
			}else if(map[word[i]-'a']==1) {
				return false;
			}
		}
		return true;
	}
	
	static int lengthOflongestSubstring(String s) {
		if(s.length()==0) {
			return 0;
		}
		char[] word= s.toCharArray();
		int st=0;
		int en=0;
		int max=-999999;
		for(en=st+1;en<word.length;en++) {
			if(checkSubstr(st, en, word)) {
				continue;
			}else {
				max = Math.max(max, en-st);
				st=en;
			}
		}
		max = Math.max(max, en-st);
		return max;
	}
	public static void main(String[] args) {
		System.out.println(lengthOflongestSubstring("svsf"));
		System.out.println("sdsfdsff");

	}

}
