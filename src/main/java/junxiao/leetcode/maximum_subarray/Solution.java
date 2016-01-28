package junxiao.leetcode.maximum_subarray;

import java.util.*;

public class Solution {
	public int maxSubArray(int[] nums){
		int sum_max = Integer.MIN_VALUE;
		int sum_so_far = 0;
		// a b c d e
		for(int n : nums){
			if (sum_so_far>=0){
				sum_so_far+=n;
			}
			else{
				//sum_so_far<0
				sum_so_far=n;
			}
			sum_max = Math.max(sum_max, sum_so_far);
		}
		return sum_max;
	}
}
