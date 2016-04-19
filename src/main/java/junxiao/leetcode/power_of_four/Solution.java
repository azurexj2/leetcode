package junxiao.leetcode.power_of_four;

import java.util.*;

public class Solution {
    public boolean isPowerOfFour(int num) {
        // odd bit must be 1
        return (num>0 && 
                (num&(num-1))==0 &&
                ((num&0x55555555) !=0));
    }
}