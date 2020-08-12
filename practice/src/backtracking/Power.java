package backtracking;

import java.util.HashMap;
import java.util.Map;

public class Power {

	static Map<String, Double> lookup;
	static double multiply(double x, int n) {
		if(lookup.containsKey(x+"+"+n)) {
			return lookup.get(x+"+"+n);
		}
		double ans =0;
		if(n==1) {
			return x;
		}
		if(n==0) {
			return 1;
		}
		if(n%2==0) ans=multiply(x, n/2)*multiply(x, n/2);
		else  ans= multiply(x, n/2)*multiply(x, n/2)*x;
		lookup.put(x+"+"+n, ans);
		return ans;
	}
	 static double myPow(double x, int n) {
		 lookup = new HashMap<String, Double>();
		 double ans=1;
		 ans = multiply(x, Math.abs(n));
	  
	       if(n<0) {
	    	   return 1.0/ans;
	       }else {
	    	   return ans;
	       }
	    }
	public static void main(String[] args) {
	
		System.out.println(myPow(10.00000, -3));

	}

}
