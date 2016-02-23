package junxiao.leetcode.first_missing_positive;

import java.util.*;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Solution {
	public int firstMissingPositive(int[] nums){
		int len = nums.length;
		//first should "1", last should be n
		//i is at A[i-1]
		//A[i] has i+1
		for (int i = 0; i < len; ++i){
			while(nums[i]!=i+1){
				if (nums[i]<=0 || nums[i]>n || nums[nums[i]-1]==nums[i])
					break;
				swap(nums,i,nums[i]-1);
			}
		}
		for (int i=0; i<len;++i){
			if (nums[i]!=i+1)
				return i+1; 
		}
		return len +1;
	}
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
