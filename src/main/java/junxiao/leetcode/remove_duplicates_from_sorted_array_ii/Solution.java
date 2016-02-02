package junxiao.leetcode.remove_duplicates_from_sorted_array_ii;

import java.util.*;

public class Solution {
	public int removeDuplicates(int[] nums){
		if (nums==null) return 0;
		if (nums.length<=2) return nums.length;
		// i indicate what we want,
		// j is the running front
		int i = 1, j = 2;
		for(;j<nums.length;++j){
			//we need include nums[j] only if nums[j]!=nums[i-1]
			if (nums[j]!=nums[i-1]){
				swap(nums,i+1,j);
				++i;
			}
		}
		return i+1;
	}
	public void swap(int[] nums,int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
