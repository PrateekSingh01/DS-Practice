package augLong2020;

import java.util.Scanner;

public class CRDGAME3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int chefNum = sc.nextInt();
				int rickNum = sc.nextInt();
				int chefCount = chefNum/9;
				chefCount += chefNum%9;
				int rickCount =  rickNum/9;
				rickCount += rickNum%9;
				if(rickCount<chefCount) {
					System.out.println("1"+" "+rickCount);
				}else {
					System.out.println("0"+" "+chefCount);
				}
			}
			
		}
	}

}
