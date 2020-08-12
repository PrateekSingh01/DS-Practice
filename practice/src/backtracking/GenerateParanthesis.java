package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	static List<String> ans;

	static void helper(int val, String currVal, int n) {
		if (val < 0||val>n) {
			return;
		}
		
		if (currVal.length() == 2 * n) {
			if(val==0) {
				ans.add(currVal);
			}
			return;
		}
		helper(val + 1, currVal + "(", n);
		helper(val - 1, currVal + ")", n);
		
	}

	static List<String> generateParenthesis(int n) {
		ans = new ArrayList<String>();
		helper(0, "", n);
		return ans;
	}

	public static void main(String[] args) {
		generateParenthesis(3);
		System.out.println("dfdg");

	}

}
