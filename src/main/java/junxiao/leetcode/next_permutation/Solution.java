package junxiao.leetcode.next_permutation;

import java.util.*;

public class Solution {
	public void nextPermutation(int[] nums) {
		if (nums.length <=1) return;
		//find the first we can enlarge
		for (int i = nums.length-2;i>=0;--i){
			if (nums[i] < nums[i+1]){
				//then the find the smallest we can swap
				// the one just larget than num.get(i)
				for (int j=nums.length-1;j>i;--j){
					if (nums[j]>nums[i]){
						swap(nums,i,j);
						reverse(nums, i+1, nums.length-1);
						return;
					}
				}
			}
		}
		reverse(nums,0,nums.length-1);
	}
	public void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public void reverse(int[] arr, int i, int j){
		while (i<j){
			swap(arr,i,j);
			++i;
			--j;
		}
	}
}
