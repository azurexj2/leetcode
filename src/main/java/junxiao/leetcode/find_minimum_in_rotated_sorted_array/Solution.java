package junxiao.leetcode.find_minimum_in_rotated_sorted_array;

import java.util.*;

public class Solution {
	public int findMin(int[] nums){
		int L = 0, H = nums.length-1;
		while(L<H){
			int M = L + (H-L)/2;
			if (nums[M] > nums[H]){
				//we are in left
				L = M +1;
			}
			else {
				H = M;
			}
		}
		return nums[L];
	}
}
