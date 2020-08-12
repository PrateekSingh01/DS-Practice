package stack;

import java.util.Stack;

public class AsteroidCollision {

	public static int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length == 0) {
			return new int[0];
		}
		Stack<Integer> st = new Stack<>();
		for (int i : asteroids) {
			if (i > 0) {
				st.push(i);
			} else {
				while (true) {
					// i is -ve
					if (st.isEmpty()) {
						st.push(i);
						break;
					}
					int top = st.peek();
					int res = top + i;
					if (res > 0) {
						break;
					} else if (res == 0) {
						st.pop();
						break;
					} else {
						if (top > 0) {
							st.pop();
						} else {
							st.push(i);
							break;
						}
					}
				}
			}
		}
		Integer a[] = new Integer[st.size()];
		a = st.toArray(a);
		int b[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public static void main(String[] args) {
		int a[] = { -2, -1, 1, 2 };
		int[] b = asteroidCollision(a);
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("dfdf");
	}

}
