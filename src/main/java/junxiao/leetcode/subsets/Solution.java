package junxiao.leetcode.subsets;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if (nums==null) return res;
		List<Integer> path = new ArrayList<>();
		Arrays.sort(nums);
		dfs(nums,res,path,0);
		return res;
	}
	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int pos){
		if (pos>=nums.length){
			res.add(path.stream().collect(Collectors.toList()));
			return;
		}
			dfs(nums,res,path,pos+1);
			path.add(nums[pos]);
			dfs(nums,res,path,pos+1);
			path.remove(path.size()-1);
	}
}
