package junxiao.leetcode.ugly_number_ii;

import java.util.*;

public class Solution {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        int[] uglyNum = new int[n];
        uglyNum[0]=1;
        int[] m2 = new int[n];
        m2[0]=2;
        int[] m3 = new int[n];
        m3[0]=3;
        int[] m5 = new int[n];
        m5[0]=5;
        int ind2=0, ind3=0, ind5=0;
        int count = 1;
        while (count<n){
            int minOfThree = Math.min(Math.min(m2[ind2],m3[ind3]),m5[ind5]);
            uglyNum[count]=(minOfThree);
            m2[count]=(minOfThree*2);
            m3[count]=(minOfThree*3);
            m5[count]=(minOfThree*5);
            ++count;
            if (minOfThree==m2[ind2])
                ++ind2;
            if (minOfThree==m3[ind3])
                ++ind3;
            if (minOfThree==m5[ind5])
                ++ind5;
        }
        return uglyNum[n-1];
        
    }
}