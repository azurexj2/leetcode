package junxiao.leetcode.path_sum_ii;

import java.util.*;
import java.util.stream.Collectors;

import junxiao.leetcode.TreeNode;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(root,sum,res,path);
		return res;
	}
	private void dfs(TreeNode root, int sum, List<List<Integer>> res,
			     List<Integer> path){
		if (root==null)	return;
		if (root.left==null && root.right==null && sum==root.val){
			path.add(root.val);
			res.add(path.stream().collect(Collectors.toList()));
			path.remove(path.size()-1);
			return;
		}
		path.add(root.val);
		dfs(root.left,sum-root.val,res,path);
		dfs(root.right,sum-root.val,res,path);
		path.remove(path.size()-1);
	}
}
