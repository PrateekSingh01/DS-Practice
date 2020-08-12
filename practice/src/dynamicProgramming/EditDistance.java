package dynamicProgramming;

public class EditDistance {

	static int recurse(String word1, String word2, int idx1, int idx2) {
		int val =0;
		if(idx1==word1.length()-1) {
			return word2.length()-idx2;
		}
		
		if(idx2==word2.length()-1) {
			return word1.length()-idx1;
		}
		
		if(word1.charAt(idx1)==word2.charAt(idx2)) {
			return recurse(word1, word2, idx1+1, idx2+1);
		}
		
		val = Integer.min(1+recurse(word1, word2, idx1, idx2+1), Integer.min(1+recurse(word1, word2, idx1+1, idx2), 2+recurse(word1, word2, idx1+1, idx2+1)));
		
		return val;
	}
	static int minDistance(String word1, String word2) {
		int ans=-1;
		System.out.println(recurse(word1, word2, 0, 0));
		
		return -1;
	}
	public static void main(String[] args) {
		minDistance("intrinsic", "intrusive");
	}

}
