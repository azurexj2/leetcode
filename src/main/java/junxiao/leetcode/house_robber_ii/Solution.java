package junxiao.leetcode.house_robber_ii;

import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        if (len==1) return nums[0];
        if (len==2) return Math.max(nums[0],nums[1]);
        if (len==3) return Math.max(nums[0], Math.max(nums[1],nums[2]));
        //let's look at nums[0],
        // 1. 0 is not robbed, then len-1 is free to rob robLine(1 to len-1)
        //2. 0 is robbed, then 1 and len-1 cannot be rob, robLine(2, len-2)
        return Math.max(robLine(Arrays.copyOfRange(nums,1,len)),
                        nums[0] + robLine(Arrays.copyOfRange(nums,2, len-1)));
        
    }
    private int robLine(int[] nums){
        int len = nums.length;
        if (len==0) return 0;
        if (len==1) return nums[0];
        int exclusive = 0;
        int inclusive = nums[0];
        for (int i = 1; i < len; ++i){
            int tmp = inclusive;
            inclusive = Math.max(inclusive, exclusive+nums[i]);
            exclusive = tmp;
        }
        return inclusive;
    }
}