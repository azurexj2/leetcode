package junxiao.leetcode.best_time_to_buy_and_sell_stock_iv;

import java.util.*;

public class Solution {
	public int maxProfit(int k, int[] prices){
		if (prices==null) return 0;
		int len = prices.length;
		if (len <=1) return 0;
		int profit = 0;
		if (k>=len/2){
			for (int i =1 ; i<len;++i){
				if (prices[i]>prices[i-1])
					profit+= (prices[i]-prices[i-1]);
			}
			return profit;
		}
		int[][] Pro = new int[k+1][len];
		// pro[i][j]  i transiion at time j
		// pro[i][0] is reserved as 0;
		int max_m = -prices[0];
		for (int i = 1; i <=k; ++i){
			for (int j = 1;j<len;++j){
				//no transiion at j: Pro[i][j-1]
				//dummy transion at j: Pro[i-1][j]
				Pro[i][j] = Math.max(Pro[i-1][j], Pro[i][j-1]);
				// max_m : Pro[i-1][m] + prices[j]-prices[m]
				//==> prices[j] + max_m (Pro[i-1][m] -prices[m])
				//we can accumulate max_m over time.
				Pro[i][j] = Math.max(Pro[i][j], prices[j]+max_m);
				max_m = Math.max(max_m, Pro[i-1][j] - prices[j]);
				
			}
		}
		return Pro[k][len-1];

	}
}
