package junxiao.leetcode.search_in_rotated_sorted_array;

import java.util.*;

public class Solution {
	public int search(int[] nums, int target){
		if (nums==null || nums.length==0) return -1;
		int L = 0, H = nums.length-1;
		while(L<=H){
			int M = L + (H-L)/2;
			//first test M in left or right monolinc increase section
			if (nums[M]==target){
				return M;
			}
			else if (nums[M]>=nums[L]){
				// we in left
				if (target>=nums[L] && target<nums[M]){
					// we in monolic section
					H = M -1;
				}
				else {
					L = M + 1;
				}
			}
			else {
				//we in right
				if (target>nums[M] && target<=nums[H]){
					//in monolic section
					L = M+1;
				}
				else {
					H = M -1;
				}
			}
		}
		return -1;
	}
}
