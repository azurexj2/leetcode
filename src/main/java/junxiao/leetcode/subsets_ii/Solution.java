package junxiao.leetcode.subsets_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if (nums==null || nums.length==0) return res;
		Arrays.sort(nums);
		List<Integer> path = new ArrayList<>();;
		dfs(nums,res,path,0);
		return res;
	}
	public void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int pos){
		if (pos >= nums.length){
			res.add(path.stream().collect(Collectors.toList()));
			return;
		}
		//need skip subset(pos+1) for duplication
		// because nums[pos] + subset(pos+1) will contain it
		//we need find an non-duplicate value
		//[b, b, c, d] ==> subset [c, d]
		int ind = pos;
		while(ind<nums.length-1 && nums[ind+1]==nums[ind]){
			++ind;
		}
   		    
		dfs(nums,res,path,ind+1);
		
		path.add(nums[pos]);
		dfs(nums,res,path,pos+1);
		path.remove(path.size()-1);
	}
}
