package backtracking;

public class RegularExpressionMatching {

	static boolean traverse(String s, char prev,String p, int sidx,int pidx) {
		if (sidx == s.length() - 1) {
			
		}
		if(s.charAt(sidx)==p.charAt(pidx)||p.charAt(pidx)=='.') {
			return traverse(s,prev, p, sidx+1, pidx+1);
		}else if(p.charAt(pidx)=='*') {
			boolean ans=false;
			for(int i=sidx;i<s.length();i++) {
				if(!ans) {
					ans = traverse(s,p.charAt(pidx-1) ,p, i,pidx+1);
				}else {
					break;
				}
			}
			return ans;
		}else {
			traverse(s,prev, p, sidx, pidx+1);
		}
		return false;
	}

	public static void main(String[] args) {
//		System.out.println(isMatch("aab", "c*a*b"));

	}

}
