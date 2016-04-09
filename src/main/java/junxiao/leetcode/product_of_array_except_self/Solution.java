package junxiao.leetcode.product_of_array_except_self;

import java.util.*;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] below = new int[n];
        int[] above = new int[n];
        int pre = 1;
        // output[i] = below[i] * above[i];
        // first pass output[i] = below[i];
        // second pass, output[i] *= above[i], where pre = above[i];
        for (int i =0; i <n;++i){
            output[i] = pre;
            pre *= nums[i];
        }
        pre = 1;
        for (int i=n-1;i>=0;--i){
            output[i] *= pre;
            pre *= nums[i];
        }
        return output;
        
    }
}