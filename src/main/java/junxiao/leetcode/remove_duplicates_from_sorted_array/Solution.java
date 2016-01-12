package junxiao.leetcode.remove_duplicates_from_sorted_array;

import java.util.*;

public class Solution {
	public int removeDuplicates(int[] nums) {
		if (nums.length<=1) return nums.length;
		// i indicate no-duplication element.
		// i+1 is the new place 
		// j indecate currently running front
		int i = 0, j = 1;
		for (;j<nums.length;++j){
			if (nums[j]!=nums[i]){
				nums[i+1] = nums[j];
				++i;
			}
		}
		return i+1;
	}
}
