package junxiao.leetcode.three_sum_closest;

import java.util.*;

public class Solution {
	public int threeSumClosest(int[] nums, int target){
		Arrays.sort(nums);
		int dif = Integer.MAX_VALUE;
		int res = 0;
		for (int i =0; i < nums.length-2;++i){
			int j = i+1;
			int k = nums.length-1;
			while (j<k){
				int sum = nums[i]+nums[j]+nums[k];
				if (sum == target){
					return target;
				}
				else if (sum < target){
					++j;
				}
				else {
					--k;
				}
				if (Math.abs(sum-target) < dif){
					res = sum;
					dif = Math.abs(sum-target);
				}
			}
		}
		return res;
	}
}
