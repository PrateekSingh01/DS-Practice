package juneLong2020;

import java.util.Arrays;
import java.util.Scanner;

public class ChefAndIcecream {

	static int[] lookup;
	private static boolean solve(int arr[], int idx, int change[]) {
		if (idx >= arr.length) {
			return true;
		}
		else if(lookup[idx]!=-1) {
			return lookup[idx]==0?false:true;
		}
		else {
			boolean ans;
			if (arr[idx] == 5) {
				change[0]++;
				ans= solve(arr, idx + 1, change);
			} else if (arr[idx] == 10) {
				change[1]++;
				if (change[0] <= 0) {
					ans= false;
					return ans;
				}
				change[0]--;
				ans= solve(arr, idx + 1, change);
				return ans;
			} else {
				change[2]++;
				int[] fiveDeduct = Arrays.copyOf(change, 3);
				int[] tenDeduct = Arrays.copyOf(change, 3);
				boolean fiveTry;
				boolean tenTry;
				if(fiveDeduct[0]<2) {
					fiveTry= false;
					
				}else {
					fiveDeduct[0]-=2;
					fiveTry =solve(arr, idx+1, fiveDeduct);
				}
				
				if(tenDeduct[1]<1) {
					tenTry= false;
				
				}else {
					tenDeduct[1]--;
					tenTry = solve(arr, idx+1, tenDeduct);
				}
				
				ans= fiveTry||tenTry;
				lookup[idx] = ans?1:0;
				return ans;
			}
			return ans;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			int t = Integer.parseInt(sc.nextLine());
			
			for (int i = 0; i < t; i++) {
				int[] change = new int[3];
				
				int values = Integer.parseInt(sc.nextLine());
				lookup = new int[values];
				Arrays.fill(lookup, -1);
				String[] strarr=sc.nextLine().split(" ");
				int[] arr=new int[strarr.length];
				for (int j = 0; j < values; j++) {
					arr[j] = Integer.parseInt(strarr[j]);
				}
				if(solve(arr, 0, change)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}

	}

}
