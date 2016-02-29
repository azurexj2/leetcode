package junxiao.leetcode.minimum_size_subarray_sum;

import java.util.*;

public class Solution {
	public int minSubArrayLen(int s, int[] nums){
		int len = nums.length;
		if (len==0) return 0;
		int slow = 0;
		int minLen = Integer.MAX_VALUE;
		int sumSoFar = 0;
		for (int i=0; i<len;++i){
			sumSoFar += nums[i];
			if (sumSoFar >= s){
				while(slow<len && sumSoFar - nums[slow] >= s){
					++slow;
				}
				minLen = Math.min(minLen, i-slow+1);
			}
		}
		return minLen==Integer.MAX_VALUE? 0:minLen;
	}
	public int minSubArrayLen(int s, int[] nums){
		int len = nums.length;
		if (len==0) return 0;
		int slow = 0;
		int fast = 0;
		int minLen = Integer.MAX_VALUE;
		int sumSoFar = 0;
		while(fast<len){
			sumSoFar += nums[fast];
			while(sumSoFar>=s){
				//move left
				sumSoFar-=nums[slow++];
				minLen = Math.min(minLen, fast-slow+1);
			}
			++fast;
		}
		return minLen==Integer.MAX_VALUE?0:minLen;
	}
}
