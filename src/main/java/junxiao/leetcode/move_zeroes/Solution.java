package junxiao.leetcode.move_zeroes;

import java.util.*;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Solution {
	public void moveZeroes(int[] nums){
		if (nums==null) return;
		int len = nums.length;
		if (len<=1) return;
		int nonZeroInd = 0;
		// now zeroInd point to fisrt non-zero
		for (int i =0 ; i<len;++i){
			if (nums[i]!=0){
				swap(nums,i,nonZeroInd++);
			}
		}
	}
	private void swap(int[] nums, int i , int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
