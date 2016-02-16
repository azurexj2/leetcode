package junxiao.leetcode.maximum_product_subarray;

import java.util.*;

public class Solution {
	public int maxProduct(int[] nums){
		int len = nums.length;
		if (len==1) return nums[0];
		int maxSoFar = nums[0];
		int minSoFar = nums[0];
		int max = nums[0];
		for (int i = 1; i < len; ++i){
			if (nums[i]>=0){
				maxSoFar = Math.max(nums[i], maxSoFar*nums[i]);
				minSoFar = Math.min(nums[i], minSoFar*nums[i]);
			}
			else {
				//nums[i]<0
				maxSoFar = Math.max(nums[i], minSoFar*nums[i]);
				minSoFar = Math.min(nums[i], maxSoFar*nums[i]);
			}
			max = Math.max(max, maxSoFar);
		}
		return max;
	}
}
