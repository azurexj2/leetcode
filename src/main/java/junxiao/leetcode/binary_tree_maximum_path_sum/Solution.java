package junxiao.leetcode.binary_tree_maximum_path_sum;

import java.util.*;

import junxiao.leetcode.TreeNode;

public class Solution {
	private int maxSum;
	public int maxPathSum(TreeNode root) {
		if (root==null) return 0;
		maxSum = Integer.MIN_VALUE;
		int l = doPath(root.left);
		int r = doPath(root.right);
		int sum = root.val + l>0?l:0 + r>0?r:0;
		return Math.max(sum, maxSum);
		
	}
	private int doPath(TreeNode root){
		//return one path maxium
		//compute max it see
		if (root==null) return 0;
		int l = doPath(root.left);
		int r = doPath(root.right);
		int sum = root.val + l>0?l:0 + r>0?r:0;
		maxSum = Math.max(sum, maxSum);
		int pathSum = l>r?l:r;
		return root.val + pathSum>0?pathSum:0;
	}
}
