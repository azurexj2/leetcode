package junxiao.leetcode.combinations;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> combine(int n, int k){
		int[] nums = new int[n];
		for (int i=1;i<=n;++i){
			nums[i-1] = i;
		}
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(nums,res,path,0,k);
		return res;
	}
	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path,int pos, int k){
		if (path.size()==k){
			res.add(path.stream().collect(Collectors.toList()));
			return;
		}
		for (int i = pos; i < nums.length;++i){
			path.add(nums[i]);
			dfs(nums,res,path,i+1,k);
			path.remove(path.size()-1);
		}
	}
}
