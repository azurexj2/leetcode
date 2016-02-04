package junxiao.leetcode.unique_binary_search_trees_ii;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public List<TreeNode> generateTrees(int n){
		List<TreeNode> res = new ArrayList<>();
		res = helper(1,n);
		return res;
	}
	public List<TreeNode> helper(int begin, int end){
		List<TreeNode> res = new ArrayList<>();
		if (begin>end){
			res.add(null);
			return res;
		}
		
		for(int i = begin; i <=end; ++i){
			List<TreeNode> left = helper(begin,i-1);
			List<TreeNode> right = helper(i+1,end);
			for (TreeNode head_l : left){
				for (TreeNode head_r : right){
					TreeNode head = new TreeNode(i);
					head.left = head_l;
					head.right = head_r;
					res.add(head);
				}
			}
		}
		return res;
	}
}
