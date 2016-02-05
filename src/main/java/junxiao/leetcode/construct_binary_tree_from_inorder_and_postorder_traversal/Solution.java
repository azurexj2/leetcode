package junxiao.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.*;
import junxiao.leetcode.TreeNode;

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i=0; i<  inorder.length;++i){
			map.put(inorder[i],i);
		}
		return helper(map, inorder,0,inorder.length-1,
				      postorder,0,postorder.length-1);
	}
	private TreeNode helper(Map<Integer,Integer> map, int[] inorder, int b_in, int e_in,
			                int[] postorder, int b_po, int e_po){
		if (b_in>e_in || b_po>e_po) return null;
		TreeNode head = new TreeNode(postorder[e_po]);
		int ind = map.get(postorder[e_po]);
		head.left = helper(map,inorder,b_in,ind-1,
				     postorder, b_po, b_po+ind-b_in-1);
		head.right = helper(map,inorder,ind+1,e_in,
				          postorder,b_po+ind-b_in, e_po-1);
		return head;
		
	}
}
