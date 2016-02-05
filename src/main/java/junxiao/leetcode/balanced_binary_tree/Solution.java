package junxiao.leetcode.balanced_binary_tree;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public boolean isBalanced(TreeNode root){
		int h = helper(root);
		if (h==-1)
			return false;
		return true;
	}
	private int helper(TreeNode root){
		if (root==null) return 0;
		int l = helper(root.left);
		if (l==-1)
			return -1;
		int r = helper(root.right);
		if (r==-1)
			return -1;
		if (Math.abs(l-r)>1)
			return -1;
		else 
			return Math.max(l, r)+1;
		
	}
}
