package junxiao.leetcode.four_sum;

import java.util.*;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		//i,j,k,l
		for (int i=0; i< nums.length-3;++i){
			if (i>0 && nums[i]==nums[i-1]) continue;
			for (int j = i+1; j < nums.length-2;++j){
				if (j>i+1 && nums[j]==nums[j-1]) continue;
			int k=j+1, l = nums.length-1;
			while (k<l){
				if (k>j+1 && nums[k]==nums[k-1]) {
					++k;
					continue;
				}
				int tmp = nums[i]+nums[j]+nums[k]+nums[l];
				if (tmp == target){
					res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
					++k;
					--l;
				}
				else if (tmp < target){
					++k;
				}
				else if (tmp > target){
					--l;
				}
			}
				
			}
		}
		return res;
	}
}
