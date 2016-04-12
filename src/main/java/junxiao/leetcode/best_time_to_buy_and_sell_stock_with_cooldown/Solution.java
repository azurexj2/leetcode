package junxiao.leetcode.best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.*;

public class Solution {
    public int maxProfit(int[] prices) {
        // three state, xxx[i] means max profit can get at time i-1, that the ending action is xxx
        // buy[i] = max(buy[i-1], idle[i-1]-prices[i-1]), //buy[i-1] or buy[i]
        // sell[i] = max(sell[i-1], buy[i-1]+price[i-1])
        // idle[i] = max(idle[i-1),sell[i-1]), //no buy action followd by idle
        
        //note that idle[i] <= sell[i]
        // we can draw fsm to understand:

        int len = prices.length;
        int[] buy = new int[len+1];
        int[] sell = new int[len+1];
        int[] idle = new int[len+1];
        buy[0] = Integer.MIN_VALUE;
        for (int i =1; i <=len; ++i){
            buy[i] = Math.max(buy[i-1], idle[i-1]-prices[i-1]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i-1]);
            idle[i] = Math.max(idle[i-1],sell[i-1]);
        }
        return sell[len];
    }
}