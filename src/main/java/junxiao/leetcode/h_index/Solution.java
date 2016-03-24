package junxiao.leetcode.h_index;

import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len==0) return  len;
        int[] h = new int[len+1];
        //citation n of a paper can contribute to h<=n
        //let's count one for h==n
        for (int n : citations){
            if (n>=len)
                ++h[len];
            else{
                ++h[n];
            }
        }
        int sum = 0;
        for (int i = len; i>=0;--i){
            sum += h[i];
            if (sum>=i)
                return i;
        }
        return 0;
    }
}
