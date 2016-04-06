package junxiao.leetcode.paint_house;

import java.util.*;

public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n==0) return 0;
        int[][] price = new int[n][3];
        //[0] r
        //[1] b
        //[2] g
        // for price of i, printing in r is: costs[i][r] + min(price[i-1][g],price[i-1][b])
        for (int i = 0; i <3; ++i){
            price[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; ++i){
           price[i][0] = costs[i][0] + Math.min(price[i-1][1],price[i-1][2]); 
           price[i][1] = costs[i][1] + Math.min(price[i-1][0],price[i-1][2]); 
           price[i][2] = costs[i][2] + Math.min(price[i-1][0],price[i-1][1]); 
        }
        return Math.min(price[n-1][0], Math.min(price[n-1][1],price[n-1][2]));
     }
}