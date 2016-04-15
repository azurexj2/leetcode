package junxiao.leetcode.coin_change;

import java.util.*;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] count = new Integer[amount+1];
        Arrays.fill(count,null);
        count[0] = 0;
        //count[i] store the least coins needed for amount i
        //count[i] = min (count[i-j]+1)
        for (int i = 1; i <=amount;++i){
            for (int c : coins){
                if (i-c>=0 && count[i-c]!=null){
                    if (count[i]==null) 
                        count[i] = count[i-c]+1;
                    else 
                        count[i] = Math.min(count[i],count[i-c] + 1);
                }
            }
        }
    return count[amount]==null? -1 : count[amount]; 
    }
}