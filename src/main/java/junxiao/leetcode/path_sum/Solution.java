package junxiao.leetcode.path_sum;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum){
		if (root==null) return false;
		if (root.left==null && root.right==null && sum==root.val)
			return true;
		if (root.left!=null){
			if (hasPathSum(root.left,sum-root.val))
				return true;
		}
		if (root.right!=null){
			if (hasPathSum(root.right,sum-root.val))
				return true;
		}
		return false;

	}
}
