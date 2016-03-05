package junxiao.leetcode.invert_binary_tree;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public TreeNode invertTree(TreeNode root){
		if (root==null) return root;
		if (root.left==null && root.right==null) return root;
		if (root.left!=null){
			invertTree(root.left);
		}
		if (root.right!=null){
			invertTree(root.right);
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
}
