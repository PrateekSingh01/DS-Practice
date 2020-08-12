package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinimumCostForTickets {

	static Map<String,Integer> lookup;
	static int helper(int[] days,int[] cost,int limit,int currentIdx) {
		int ans=0;
		if(lookup.containsKey(limit+"|"+currentIdx)) {
			return lookup.get(limit+"|"+currentIdx);
		}else {
			if(currentIdx>days.length-1) {
				return 0;
			}
			if(limit>days[days.length-1]) {
				return 0;
			}
			
			if(limit>days[currentIdx]) {
				ans = helper(days, cost, limit, currentIdx+1);
			}else {
				ans = Integer.min(cost[0]+helper(days, cost, days[currentIdx], currentIdx+1), 
						Integer.min(cost[1]+helper(days, cost, days[currentIdx]+7, currentIdx+1), 
								cost[2]+helper(days, cost, days[currentIdx]+30, currentIdx+1)));
			}
			
			lookup.put(limit+"|"+currentIdx, ans);
		}
		
		return ans;
	}
static int mincostTickets(int[] days, int[] costs) {
		lookup =new HashMap<String, Integer>();
        int ans=-1;
        ans = helper(days, costs, 0, 0);
        System.out.println(ans);
        return ans;
    }
	public static void main(String[] args) {
		int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
		int [] costs = {2,7,15};
		mincostTickets(days, costs);
	}

}
