package junxiao.leetcode.find_peak_element;

import java.util.*;

public class Solution {
	public int findPeakElement(int[] nums){
		int len = nums.length;
		if (len==1) return nums[0];
		if (nums[1]<nums[0])
			return nums[0];
		if (nums[len-2]<nums[len-1])
			return nums[len-1];
		int L = 0, H = len-1;
		while(L<=H){
			int M = L + (H-L)/2;
			
		}
	}
}
