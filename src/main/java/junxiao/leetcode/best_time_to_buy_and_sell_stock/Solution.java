package junxiao.leetcode.best_time_to_buy_and_sell_stock;

import java.util.*;

public class Solution {
	public int maxProfit(int[] prices){
		//when max profit happen??
		// for sell at day i, the profit = price[i]-min_so_far
		if (prices==null) return 0;
		if (prices.length<=1) return 0;
		int minSoFar = prices[0];
		int maxProfit = 0;
		for (int i = 1; i< prices.length;++i){
			int tmp = prices[i]-minSoFar;
			maxProfit=Math.max(maxProfit, tmp);
			minSoFar = Math.min(minSoFar, prices[i]);
		}
		return maxProfit;
		
	}
}
