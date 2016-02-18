package junxiao.leetcode.rotate_array;

import java.util.*;

public class Solution {
	public void rotate(int[] nums, int k){
		int len = nums.length;
		if (len<=1) return;
		k = k%len;
		reverse(nums, 0, len-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, len-1);
	}
	void reverse(int[] nums, int i, int j){
		while (i<j){
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			++i;
			--j;
		}
	}
}
