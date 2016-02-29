package junxiao.leetcode.recover_binary_search_tree;

import java.util.*;

import junxiao.leetcode.TreeNode;

public class Solution {
	private TreeNode pre;
	private TreeNode first;
	private TreeNode second;
	public void recoverTree(TreeNode root){
		recover(root);
		swap(first, second);
	}
	public void recover(TreeNode root){
	    if (root==null) return;
	    if (root.left!=null)
	    	recover(root.left);
	    //do here
	    if (pre!=null && root.val < pre.val){
	    	//
	    	if (first==null){
	    		first = pre;
	    		second = root; // trick here for two pair next to each other
	    	}
	    	else{
	    		second = root;
	    		return;
	    	}
	    }
	    pre = root;
	    if (root.right!=null)
	    	recover(root.right);
		
	}
	private void swap(TreeNode n1, TreeNode n2){
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
	}
}
