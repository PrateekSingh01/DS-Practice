package juneLong2020;

import java.util.Scanner;

public class ChefAndPriceControl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int ans = 0;
				int n = sc.nextInt();
				int k = sc.nextInt();
				for (int j = 0; j < n; j++) {
					int currVal = sc.nextInt();
					if (currVal > k) {
						ans += currVal - k;
					}
				}
				System.out.println(ans);
			}
		}

	}

}
