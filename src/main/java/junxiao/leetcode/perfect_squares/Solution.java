package junxiao.leetcode.perfect_squares;

import java.util.*;

public class Solution {
    public int numSquares(int n) {
        if (n<=3) return n;
        //DP
        int[] len = new int[n+1];
        Arrays.fill(len,Integer.MAX_VALUE);
        len[0] = 0;
        for (int i = 1; i <=n; ++i){
            for (int j = 1; j*j<=i; ++j)
                len[i] = Math.min(len[i], len[i-j*j]+1);
        }
        return len[n];
    }
}