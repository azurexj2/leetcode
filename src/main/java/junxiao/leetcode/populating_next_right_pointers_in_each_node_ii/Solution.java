package junxiao.leetcode.populating_next_right_pointers_in_each_node_ii;

import java.util.*;

class TreeLinkNode {
    int val;
   TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class Solution {
	public void connect(TreeLinkNode root){
		if (root==null) return;
		root.next=null;
		TreeLinkNode row = root;
		while (row!=null){
			TreeLinkNode dummy = new TreeLinkNode(-1);
			dummy.next = null;
			TreeLinkNode head = dummy;
			while(row!=null){
				if (row.left!=null){
					head.next = row.left;
					head = head.next;
				}
				if (row.right!=null){
					head.next = row.right;
					head = head.next;
				}
				row = row.next;
			}
			head.next =null;
			row = dummy.next;
			
		}
		
	}
}
