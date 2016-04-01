package junxiao.leetcode.counting_bits;

import java.util.*;

public class Solution {
    public int[] countBits(int num) {
        // f(i) = f(i/2) + i%2;
        int[] f = new int[num+1];
        for (int i = 1; i <=num; ++i){
            f[i] = f[i>>1] + i%2;
        }
        return f;
    }
}