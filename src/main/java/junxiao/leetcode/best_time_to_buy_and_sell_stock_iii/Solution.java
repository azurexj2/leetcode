package junxiao.leetcode.best_time_to_buy_and_sell_stock_iii;

import java.util.*;

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length==0) return 0;
		int len = prices.length;
		if (len==1) return 0;
		// L: profit from 0 to i
		// R: profit from i to n-1
		int[] profitL = new int[len];
		int[] profitR = new int[len];
		int lowestSoFar = prices[0];
		int highestSoFar = prices[len-1];
		for (int i=1;i<len;++i){
			int tmp = Math.max(0, prices[i]-lowestSoFar); 
			profitL[i] = Math.max(profitL[i-1], tmp); 
			lowestSoFar = Math.min(lowestSoFar, prices[i]);
		}
		for (int i=len-2;i>=0;--i){
			int tmp = Math.max(0, highestSoFar - prices[i]); 
			profitR[i] = Math.max(profitL[i+1], tmp); 
			highestSoFar = Math.min(highestSoFar, prices[i]);
		}
		int maxProfit = 0;
		for (int i=0;i<len;++i){
			maxProfit = Math.max(maxProfit, profitL[i]+profitR[i]);
		}
		return maxProfit;
		
	}
}
