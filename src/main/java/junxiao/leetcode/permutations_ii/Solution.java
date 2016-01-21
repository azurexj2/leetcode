package junxiao.leetcode.permutations_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums==null) return res;
		Arrays.sort(nums);
		dfs (nums, res, 0);
		return res;
	}
	public void dfs(int[] nums, List<List<Integer>> res, int pos){
		if (pos>=nums.length){
			res.add(Arrays.asList(nums).stream().collect(Collectors.toList()));
		}
	}
}
