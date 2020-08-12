package array;

public class ValidParanthesis {

	static boolean isValid(String s) {
		char[] stack = new char[s.length()];
		int currLength=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='(') {
				stack[currLength]=s.charAt(i);
				currLength++;
			}
			if(s.charAt(i)==']') {
				if(stack[currLength-1]=='[') {
					currLength--;
				}
			}
			if(s.charAt(i)=='}') {
				if(stack[currLength-1]=='{') {
					currLength--;
				}
			}
			if(s.charAt(i)==')') {
				if(stack[currLength-1]=='(') {
					currLength--;
				}
			}
		}
		if(currLength==0) {
			return true;
		}else {
			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(isValid("(]"));

	}

}
