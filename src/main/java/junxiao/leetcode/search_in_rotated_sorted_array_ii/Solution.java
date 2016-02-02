package junxiao.leetcode.search_in_rotated_sorted_array_ii;

import java.util.*;

public class Solution {
	public boolean search(int[] nums, int target) {
		if (nums==null || nums.length==0) return false;
		int L = 0, H = nums.length-1;
		while (L<=H){
			int M = L +(H-L)/2;
			if (nums[M]==target)
				return true;
			if (nums[M]>nums[H]){
				if (target>=nums[L] && target<nums[M]){
					H = M -1;
				}
				else {
					L = M +1;
				}
			}
			else if (nums[M]<nums[H]){
				if (target >nums[M] && target<=nums[H]){
					L = M +1;
				}
				else {
					H = M -1;
				}
			}
			else {
				//nums[M]==nums[H]
				--H;
			}
		}
		return false;
	}
}
