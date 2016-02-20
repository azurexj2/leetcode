package junxiao.leetcode.house_robber;

import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int pre = nums[0];
        int cur = Math.max(nums[1],nums[0]);
        for (int i = 2; i < len; ++i){
            int tmp = cur;
            cur = Math.max(pre+nums[i], cur);
            pre = tmp;
        }
        return cur;
    }
}
