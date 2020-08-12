package stack;

import java.util.Stack;

public class PostFix {

	static int evalRPN(String[] tokens) {
		int ans =0;
		if (tokens == null || tokens.length == 0) {
			return ans;
		}
		
		Stack<Integer> st = new Stack<>();
		for(String token: tokens) {
			int val1;
			int val2;
			if("/".equals(token)) {
				if(!st.isEmpty()) {
					val1=st.pop();
				}else {
					return 0;
				}
				if(!st.isEmpty()) {
					val2=st.pop();
				}else {
					return 0;
				}
				st.add(val2/val1);
				
			}else if("*".equals(token)) {
				if(!st.isEmpty()) {
					val1=st.pop();
				}else {
					return 0;
				}
				if(!st.isEmpty()) {
					val2=st.pop();
				}else {
					return 0;
				}
				st.add(val1*val2);
			}else if("-".equals(token)) {
				if(!st.isEmpty()) {
					val1=st.pop();
				}else {
					return 0;
				}
				if(!st.isEmpty()) {
					val2=st.pop();
				}else {
					return 0;
				}
				st.add(val1-val2);
			}else if("+".equals(token)) {
				if(!st.isEmpty()) {
					val1=st.pop();
				}else {
					return 0;
				}
				if(!st.isEmpty()) {
					val2=st.pop();
				}else {
					return 0;
				}
				st.add(val1+val2);
			}else {
				st.add(Integer.parseInt(token));
			}
		}
		return st.pop();
	}

	public static void main(String[] args) {
		String[] arr = {"4","13","5","/","+"};
		System.out.println(evalRPN(arr));
	}
	
}
