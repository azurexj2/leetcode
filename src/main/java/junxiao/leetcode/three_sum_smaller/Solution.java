package junxiao.leetcode.3sum_smaller;

import java.util.*;

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        
        for (int i =0; i < len-2; ++i){
            int left = i+1;
            int right = len -1;
            while (left<right){
                if (nums[i]+nums[left]+nums[right]>=target)
                    --right;
                else {
                    count += (right-left);
                    ++left;
                }
            }
        }
        return count;
    }
}