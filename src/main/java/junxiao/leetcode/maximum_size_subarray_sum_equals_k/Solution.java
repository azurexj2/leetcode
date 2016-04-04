package junxiao.leetcode.maximum_size_subarray_sum_equals_k;

import java.util.*;

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //map store the sum[i], i
        // with nums[j], if map.containsKey(k-nums[j]),
        // then we have one match
        //remember only store the farest sum[i],
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i<nums.length;++i){
            sum += nums[i];
            if (sum==k){
                maxLen = i+1;
            }
            else if (map.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i - map.get(sum-k));
            }
            
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}