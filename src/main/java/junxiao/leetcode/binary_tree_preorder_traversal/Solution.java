package junxiao.leetcode.binary_tree_preorder_traversal;

import java.util.*;

import junxiao.leetcode.TreeNode;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		treeTravel(res,root);
		return res;
	}
	public void treeTravel(List<Integer> res, TreeNode root){
		if (root==null) return;
		res.add(root.val);
		treeTravel(res,root.left);
		treeTravel(res,root.right);
	}
	public List<Integer> preorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		if (root!=null)
			stack.addFirst(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.removeFirst();
			res.add(node.val);
			if (node.right!=null){
				stack.addFirst(node.right);
			}
			if (node.left!=null){
				stack.addFirst(node.left);
			}
		}
		return res;
	}
}
