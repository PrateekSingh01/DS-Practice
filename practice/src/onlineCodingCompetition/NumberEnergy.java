package onlineCodingCompetition;

import java.util.Scanner;

public class NumberEnergy {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        Long num = s.nextLong();
        Long val = num/2;
        Long ans=0l;
        if(num%2==0) {
        	 while(val!=0) {
             	ans+=val%10;
             	val/=10;
        	 }
        	System.out.println(ans*2);
        }else {
        	 while(num!=0) {
             	ans+=num%10;
             	num/=10;
             }
        	System.out.println(ans);
        }
	}

}
