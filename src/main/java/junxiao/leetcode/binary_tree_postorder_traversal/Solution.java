package junxiao.leetcode.binary_tree_postorder_traversal;

import java.util.*;

import junxiao.leetcode.TreeNode;

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
		treeTravel(res,root);
		return res;
	}
	public void treeTravel(List<Integer> res, TreeNode root){
		if (root==null) return;
		treeTravel(res,root.left);
		treeTravel(res,root.right);
		res.add(root.val);
	}
	public List<Integer> postorderTraversal2(TreeNode root){
		List<Integer> res = new ArrayList<>();
		TreeNode cur = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while(cur!=null){
		    stack.addFirst(cur);	
		    cur = cur.left;
		}
		TreeNode pre = null;
		while (!stack.isEmpty()){
			TreeNode node = stack.removeFirst();
			// only when node.left==null && 
			// node.right==null || node.right visited
			// then we add this node to res
			if (node.right==null || node.right == pre){
     			res.add(node.val);
     			pre = node;
			}
			else {
				//need put node back to stack
				stack.addFirst(node);
				cur = node.right;
				while(cur!=null){
					stack.addFirst(cur);
					cur = cur.left;
				}
			}
		}
		return res;
	}
}
