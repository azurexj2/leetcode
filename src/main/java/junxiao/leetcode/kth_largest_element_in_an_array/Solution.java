package junxiao.leetcode.kth_largest_element_in_an_array;

import java.util.*;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class Solution {
	private static final Random random = new Random();

	public int findKthLargest(int[] nums, int k){
		return findK(nums, 0, nums.length-1, k-1);
	}

	// return ind that left < ind, right >=ind
	private int partition(int[] nums, int begin, int end){
		int pivInd = random.nextInt(end-begin+1) + begin;
		swap(nums, pivInd, end);
		int piv = nums[end];
		int ind = begin;
		for (int i = begin; i <end; ++i){
			if (nums[i]>piv){
				swap(nums,ind,i);
				++ind;
			}
		}
		swap(nums,ind,end);
		return ind; 
	}
	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	private int findK(int[] nums, int begin, int end, int k){
		if (begin == end) return nums[begin];
		int ind = partition(nums, begin, end);
		if (ind == k) 
			return nums[ind];
		else if (ind < k){
			return findK(nums, ind+1, end, k);
		}
		else{
			return findK(nums, begin, ind-1, k);
		}
	}
	public int findKthLargest2(int[] nums, int k){
		int target = k -1;
		int len = nums.length;
		int left = 0, right = len -1;
		int ind = 0;
		while (left < right){
			int pivInd = random.nextInt(right-left+1)+left;
			swap(nums, pivInd, right);
			int piv = nums[right];
			ind = left;
			for (int i = left; i<right;++i ){
				if (nums[i]>piv){
					swap(nums,ind,i);
					++ind;
				}	
			}
			swap(nums,ind,right);
			if (ind == target) return nums[ind];
			else if (ind < target){
				left = ind +1;
			}
			else 
				right = ind -1;
		}
		return nums[left];

	}
}
