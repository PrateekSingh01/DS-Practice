package juneLong2020;

import java.util.Scanner;

public class ChefAndString {

	static int[] arr;
	private static int numberOfWays(String str,int idx) {
		int ans = 0;
		
		if(idx>=str.length()-1) {
			return 0;
		}
		if(arr[idx]!=0) {
			return arr[idx];
		}
		if(str.charAt(idx)!=str.charAt(idx+1)) {
			ans = Integer.max(numberOfWays(str, idx+1), 1+numberOfWays(str, idx+2));
		}else {
			ans = numberOfWays(str, idx+1);
		}
		arr[idx] = ans;
		return arr[idx];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextLine()){
		    int t= Integer.parseInt(sc.nextLine());
		    for(int i=0;i<t;i++){
		         String str = sc.nextLine();
		         arr = new int[str.length()];
		         System.out.println(numberOfWays(str, 0));
		    }
		   
		    
		}
	}

}
