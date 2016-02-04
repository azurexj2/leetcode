package junxiao.leetcode.binary_tree_level_order_traversal;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if (root==null) return res;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int count = queue.size();
			List<Integer> row = new ArrayList<>();
			for(int i=1;i<=count;++i){
				TreeNode node = queue.remove();
				row.add(node.val);
				if (node.left!=null)
					queue.add(node.left);
				if (node.right!=null)
					queue.add(node.right);
			}
			res.add(row);
		}
		return res;
	}
}
