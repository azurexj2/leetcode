package junxiao.leetcode.combination_sum_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates==null) return res;
		List<Integer> pattern = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, res, pattern, 0, target);
		return res;

	}
	public void dfs(int[] candidates, List<List<Integer>> res, 
			        List<Integer> pattern, int pos, int target){
		if (target==0){
			res.add(pattern.stream().collect(Collectors.toList()));
			return;
		}
		else if (target < 0 || pos >= candidates.length){
			return;
		}
		for (int i = pos; i < candidates.length; ++i){
			if (i>pos && candidates[i]==candidates[i-1]) continue;
			pattern.add(candidates[i]);
			dfs(candidates,res,pattern,i+1,target-candidates[i]);
			pattern.remove(pattern.size()-1);
		}
	}
}
