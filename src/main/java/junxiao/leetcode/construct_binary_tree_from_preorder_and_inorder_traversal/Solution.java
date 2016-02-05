package junxiao.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.*;
import junxiao.leetcode.TreeNode;
public class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder){
		return buildHelper(preorder,0,preorder.length-1,
				           inorder,0,inorder.length-1);
		//   A
		//  B C 
		// D   E
		// ABDCE, DBACE
		// subtree
		
	}
	public TreeNode buildHelper(int[] preorder,int b_pre,int e_pre,
			                    int[] inorder, int b_in, int e_in){
		if (b_pre>e_pre) return null;
		TreeNode head = new TreeNode(preorder[b_pre]);
		int ind =0;
		for (ind = b_in; ind<=e_in;++ind){
			if (inorder[ind]==preorder[b_pre])
				break;
		}
		// here ind point to the pivotal value of inorder
		head.left = buildHelper(preorder,b_pre+1,b_pre+(ind-b_in),
				                inorder, b_in, ind-1);
		head.right = buildHelper(preorder,b_pre+ind-b_in+1,e_pre,
				                inorder,ind+1,e_in);
		return head;
	}
}
