package junxiao.leetcode.permutations;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums==null) return res;
		List<Integer> pattern = new ArrayList<>();
		dfs(nums,res,pattern,0);
		return res;
	}
	public void dfs(int[] nums, List<List<Integer>> res,
			List<Integer> pattern, int pos){
		if (pos>=nums.length){
			res.add(pattern.stream().collect(Collectors.toList()));
			return;
		}
		for (int i=pos; i <nums.length;++i){
			pattern.add(nums[i]);
			swap(nums,i,pos);
			dfs(nums,res,pattern,pos+1);
			swap(nums,i,pos);
			pattern.remove(pattern.size()-1);
		}
		
	}
	public void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
