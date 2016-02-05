package junxiao.leetcode.minimum_depth_of_binary_tree;

import java.util.*;
import junxiao.leetcode.TreeNode;

import junxiao.leetcode.TreeNode;
public class Solution {
	public int minDepth(TreeNode root){
		if (root==null) return 0;
		if (root.left==null && root.right==null) return 1;
		if (root.left==null) return minDepth(root.right)+1;
		if (root.right==null) return minDepth(root.left)+1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
		
	}
}
