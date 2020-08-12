package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DiceRollsTargetSum {
	 static Map<String, Integer> dpMap;
	static int helper(int d, int currLvl, int f,int target) {
		int ans =0;
		if(!dpMap.containsKey(currLvl+"|"+target)) {
			if(target ==0 && currLvl ==d) {
				return 1;
			}
			if (target > d*f) {
				return 0;
			}
	            
			if(target <0) {
				return 0;
			}
			if(currLvl>=d) {
				return 0;
			}
			for(int i=1;i<=f;i++) {
                ans =ans%1000000007;
				ans += helper(d, currLvl+1, f, target-i)%1000000007;

			}
			dpMap.put(currLvl+"|"+target, ans);
			return ans;
		}else {
			return dpMap.get(currLvl+"|"+target);
		}
	}
	static int numRollsToTarget(int d, int f, int target) {
		int ans = -1;
		dpMap = new HashMap<>();
		System.out.println(helper(d, 0, f, target));
		return ans;
	}

	public static void main(String[] args) {
		numRollsToTarget(30,30,500);
		System.out.println("sdsfff");

	}

}
