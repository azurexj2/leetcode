package junxiao.leetcode.maximum_depth_of_binary_tree;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public int maxDepth(TreeNode root){
		if (root==null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		
	}
}
