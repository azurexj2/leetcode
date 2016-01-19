package junxiao.leetcode.combination_sum;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates==null)
			return res;
		Arrays.sort(candidates);
		List<Integer> pattern = new ArrayList<>();
		dfs(candidates,res,pattern,0,target);
		return res;
 		
	}
	public void dfs(int[] cadidates, List<List<Integer>> res,
			       List<Integer> pattern, int pos, int target){
		if (target == 0){
			res.add(pattern.stream().collect(Collectors.toList()));
			return;
		}
	    else if (target < 0){
			return;
		}
		for (int i = pos; i <cadidates.length; ++i){
			pattern.add(cadidates[i]);
			dfs(cadidates,res,pattern,i,target-cadidates[i]);
			pattern.remove(pattern.size()-1);
		}
	}
}
