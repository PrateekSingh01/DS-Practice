package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

	static String[] lookup = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static void helper(String digits, int curr, String currString, List<String> ans){
		
		if(curr==digits.length()) {
			ans.add(currString);
			return;
		}
		char[] charArr = lookup[Integer.parseInt(digits.charAt(curr)+"")].toCharArray();
		for(int i=0;i<charArr.length;i++) {
			helper(digits,curr+1,currString+charArr[i],ans);
		}
	}
	static List<String> letterCombinations(String digits){
		List<String> ans = new ArrayList<String>();
		helper(digits,0,"",ans);
		return ans;
	}
	public static void main(String[] args) {
		letterCombinations("23");
		System.out.println("sfddg");
	}

}
