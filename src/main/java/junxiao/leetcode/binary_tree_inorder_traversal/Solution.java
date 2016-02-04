package junxiao.leetcode.binary_tree_inorder_traversal;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		if (root==null) return res;
		if (root.left!=null){
			List<Integer> left = inorderTraversal(root.left);
			res.addAll(left);
		}
		res.add(root.val);
		if (root.right!=null){
			List<Integer> right = inorderTraversal(root.right);
			res.addAll(right);
		}
		return res;
	}
	public List<Integer> inorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
	    treeTravel(res,root);
	    return res;
	}
	public void treeTravel(List<Integer> res, TreeNode root){
		if (root==null) return;
		treeTravel(res,root.left);
		res.add(root.val);
		treeTravel(res,root.right);
	}
	public List<Integer> inorderTraversal3(TreeNode root){
		List<Integer> res = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		while(root!=null){
			stack.addFirst(root);
			root=root.left;
		}
		while(!stack.isEmpty()){
			TreeNode node = stack.removeFirst();
			res.add(node.val);
			root = node.right;
			while(root!=null){
				stack.addFirst(root);
				root=root.left;
			}
		}
		return res;
	}
}
