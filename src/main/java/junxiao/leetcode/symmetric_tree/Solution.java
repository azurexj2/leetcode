package junxiao.leetcode.symmetric_tree;

import java.util.*;
import junxiao.leetcode.TreeNode;
public class Solution {
	public boolean isSymmetric(TreeNode root){
		if (root==null) return true;
		return symTree(root.left,root.right);
	}
	public boolean symTree(TreeNode left, TreeNode right){
		if (left== null && right ==null)return true;
		if (left==null || right==null) return false;
		return left.val==right.val
				&& symTree(left.right,right.left)
				&& symTree(left.left, right.right);
		
	}
}
