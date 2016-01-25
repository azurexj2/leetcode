package junxiao.leetcode.permutations_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums==null) return res;
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		List<Integer> pattern = new ArrayList<>();
		Arrays.fill(used, false);
		dfs (nums, used, pattern,res, 0);
		return res;
	}
	public void dfs(int[] nums, boolean[] used, List<Integer> pattern, List<List<Integer>> res, int pos){
		if (pos>=nums.length){
			res.add(pattern.stream().collect(Collectors.toList()));
			return;
		}
		int previous = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; ++i){
			if (used[i] || 
				(i>pos && nums[i]==nums[i-1]))
				continue;
			used[i] = true;
			pattern.add(nums[i]);
			dfs(nums,used,pattern,res,pos+1);
			pattern.remove(pattern.size()-1);
			used[i] = false;
		}
	}
}
