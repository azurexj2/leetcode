package junxiao.leetcode.single_number_iii;

import java.util.*;

public class Solution {
    public int[] singleNumber(int[] nums) {
        /* 
        assume x, y are appered once
        1. xor all number get n = x ^ y
        2. then for any bit 1 of n, we can partiion nums to two set:
            each set include either x or y
        3. xor each set
        */
        int n = 0;
        for (int m : nums){
            n ^= m;
        }
        int mask=1;
        while((mask&n) == 0){
            mask <<= 1;
        }
        int num1 = 0;
        int num2 = 0;
        for (int m : nums){
            if ((mask&m)==0){
                num1 ^=m;
            }
            else {
                num2 ^=m;
            }
        }
        return new int[]{num1,num2};
    }
}