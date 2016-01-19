package junxiao.leetcode.search_for_a_range;

import java.util.*;

public class Solution {
	public int[] searchRange(int[] nums, int target){
		int l = searchLowerBound(nums, 0, nums.length-1, target);
		int r = searchLowerBound(nums, l, nums.length-1, target+1)-1;
		if (l < nums.length && nums[l]==target){
			return new int[]{l,r};
		}
		else {
			return new int[]{-1,-1};
		}
	}
	public int searchLowerBound(int[] nums, int l, int r, int target){
		int L = l, H=r;
		while (L<=H){
			int M = L + (H-L)/2;
			if (nums[M]<target){
				L = M +1;
			}
			else {
				//M>=target
				H=M-1;
			}
		}
		// L is kind of insertion position
		return L;
		
		
	}
}
