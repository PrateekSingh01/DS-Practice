package array;

public class StockBuyAndSell2 {

	 static int maxProfit(int[] prices) {
	     int ans =0,low=0,high=0;
	     for(int i=0;i<prices.length;i++) {
	    	 if(high==0) {
	    		 low = prices[i];
	    	 }
	    	 if(prices[i]<prices[i+1]) {
	    		 high = prices[i+1];
	    	 }else if(high!=0){
	    		 ans+=high-low;
	    		 high=0;
	    	 }
	     }
	     if(high!=0){
    		 ans+=high-low;
    		 high=0;
	     }
	     return ans;
	    }
	public static void main(String[] args) {
		int arr[]= {1,5,2,3,7,6,4,7};
		System.out.println(maxProfit(arr));

	}

}
