package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
	static Map<String, Integer> lookup;
	static int coinChange(int[] coins, int amount,int lastVal,int lvl) {
		int ans=0;
		if(!lookup.containsKey(lvl+"|"+amount+"|")) {
			if(amount==0) {
				return 1;
			}
			if(amount <0) {
				return 0;
			}
			for(int i=lvl;i<coins.length;i++) {
				if(coins[i]>=lastVal) {
					ans+= coinChange(coins, amount-coins[i],coins[i],i);
				}
			}
			lookup.put(lvl+"|"+amount+"|", ans);
			return ans;
		}else {
			ans = lookup.get(lvl+"|"+amount+"|");
			return ans;
		}
		
	}
	
	public static void main(String[] args) {
		int coins[] = {1,2,5};
		int amt =1000;
		lookup = new HashMap<String, Integer>();
		System.out.println(coinChange(coins,amt,-1,0));

  		System.out.println("ghgh");
	}

}
