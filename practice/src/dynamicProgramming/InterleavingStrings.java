package dynamicProgramming;

public class InterleavingStrings {

	static boolean helper(String s1, String s2, String s3, int idx1, int idx2, int idx3) {
		boolean ans = false;
		boolean selectS1 = false;
		boolean selectS2 = false;
		if(s1.length()==0) {
			return false;
		}
		if(s2.length()==0) {
			return false;
		}
		if (idx1 >= s1.length() - 1 || idx2 >= s2.length() - 1) {
			if(idx1==s3.length()/2&&idx2==s3.length()/2) {
				return true;
			}else {
				return false;
			}

		}
		if (s1.charAt(idx1) != s3.charAt(idx3) && s2.charAt(idx2) != s3.charAt(idx3)) {
			return false;
		}
		if (s1.charAt(idx1) == s3.charAt(idx3)) {
			selectS1 = helper(s1, s2, s3, idx1 + 1, idx2, idx3 + 1);
		}
		if (s2.charAt(idx2) == s3.charAt(idx3)) {
			selectS2 = helper(s1, s2, s3, idx1, idx2 + 1, idx3 + 1);
		}
		ans = selectS1||selectS2;
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(helper("aabd","abdc","aabdbadc",0,0,0));

	}

}
