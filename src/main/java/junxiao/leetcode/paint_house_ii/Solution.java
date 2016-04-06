package junxiao.leetcode.paint_house_ii;

import java.util.*;

public class Solution {
    public int minCostII(int[][] costs) {
       int n = costs.length;
       if (n==0) return 0;
       int k = costs[0].length;
       if (k==1) return costs[0][0];
       int price =0;
       int minInd = -1;
       int firstMin=0, secondMin=0;
       int prevInd = -1;
       int min1=0, min2=0;
       for (int i = 0; i < n; ++i){
           min1 = Integer.MAX_VALUE;
           min2 = Integer.MAX_VALUE;
           minInd = -1;
           for (int j = 0; j<k; ++j ){
               if (prevInd==j)
                    price = costs[i][j] + secondMin;
               else 
                    price = costs[i][j] + firstMin;
                    
               if (price < min1){
                   min2 = min1;
                   min1 = price;
                   minInd = j;
               }
               else {
                   min2 = Math.min(min2,price);
               }

           }
            firstMin = min1;
            secondMin = min2;
            prevInd = minInd;
       }
       return min1;
    }
}