package junxiao.leetcode.paint_fence;

import java.util.*;

public class Solution {
    public int numWays(int n, int k) {
        if (n==0) return 0;
        if (n==1) return k;
        int differentColor=k;
        int sameColor = 0;
        for (int i = 2; i <=n; ++i){
            int tmp = differentColor;
            differentColor = (differentColor + sameColor) * (k-1);
            sameColor = tmp;
        }
        return differentColor + sameColor;
    }
}