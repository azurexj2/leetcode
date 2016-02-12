package junxiao.leetcode.sum_root_to_leaf_numbers;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	private int sum = 0;
	public int sumNumbers(TreeNode root){
		if (root==null) return 0;
		dfs(root, 0);
		return sum;
		
	}
	private void dfs(TreeNode root, int preSum){
		if (root.left==null && root.right==null){
			sum += (preSum*10+root.val);
			return;
		}
		if (root.left!=null){
           dfs(root.left, preSum*10 + root.val);
		}
		if (root.right!=null){
           dfs(root.right, preSum*10 + root.val);
		}
	}
}
