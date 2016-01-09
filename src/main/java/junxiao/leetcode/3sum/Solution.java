package junxiao.leetcode.3sum;

import java.util.*;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		int i=0, j=0, k=0;
		for (i =0; i<nums.length-2;++i){
			if (i>0 && nums[i]==nums[i-1]) continue;
			j=i+1;
			k=nums.length-1;
			while (j<k){
				if (j>i+1 && nums[j]==nums[j-1]) {
					++j;
					continue;
				}
				int sum = nums[i]+nums[j]+nums[k];
				if (sum==0){
					res.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
					++j;
					--k;
				}
				else if (sum<0){
					++j;
				}
				else {
					--k;
				}
			}

		}
		return res;

	}
}
