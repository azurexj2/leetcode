package junxiao.leetcode.flatten_binary_tree_to_linked_list;

import java.util.*;
import junxiao.leetcode.TreeNode;
public class Solution {
	public void flatten(TreeNode root){
		if (root==null) return;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode ptr = new TreeNode(-1);
		stack.addFirst(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.removeFirst();
			ptr.right = node;
			ptr.left = null;
			if (node.right!=null)
				stack.addFirst(node.right);
			if (node.left!=null)
				stack.addFirst(node.left);
			ptr = ptr.right;
		}
		
	}
}
