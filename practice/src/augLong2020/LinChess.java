package augLong2020;

import java.util.Scanner;

public class LinChess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
			
				long n = sc.nextLong();
				long k = sc.nextLong();
				long minV = 10000000001l;
				long minI = 10001;
				for (int j = 0; j < n; j++) {
					long currVal = sc.nextLong();
					if(k%currVal==0){
					    if(((k-currVal)/currVal)<minV){
					        minV = ((k-currVal)/currVal);
					        minI = currVal; 
					    }
					  
					}
				}
				if(minI == 10001) minI =-1;
				System.out.println(minI);
			}
		}
	}

}
