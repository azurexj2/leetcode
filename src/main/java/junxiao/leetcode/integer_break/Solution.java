package junxiao.leetcode.integer_break;

import java.util.*;

public class Solution {
    public int integerBreak(int n) {
        /*
        note that 2*(n-2)>n and 3*(n-3)>n
        for 4, 2*2=2+2, 4*(optimal partion of n-4) = 2*2*f(n-4) <= 2*f(n-2)
        5*f(n-5) <= 2*3*f(n-5) <=3*f(n-3)
        for any numbre > 4, it is better partion it to factor 2 or 3
        then we know we should factor it to 2 or r
        notice that 3(n-3) > 2(n-2) if n > 5
        */
        int m = Math.max(7,n+1);
        int[] f = new int[m];
        f[2] = 1;
        f[3] = 2;
        f[4] = 4;
        f[5] = 6;
        f[6] = 9;
        for (int i =7; i<=n;++i){
            f[i] = 3 *f[i-3];
        }
        return f[n];
    }
}