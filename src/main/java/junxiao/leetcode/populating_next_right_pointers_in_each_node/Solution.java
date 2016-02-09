package junxiao.leetcode.populating_next_right_pointers_in_each_node;

import java.util.*;

class TreeLinkNode {
     int val;
    TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

public class Solution {
	public void connect(TreeLinkNode root){
		if (root==null) return;
		Deque<TreeLinkNode> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()){
			int count = queue.size();
			TreeLinkNode current;
			for (int i = 1; i<=count;++i){
				current = queue.remove();
				current.next= i==count? null : queue.peek();
				if (current.left!=null){
					queue.add(current.left);
				}
				if (current.right!=null){
					queue.add(current.right);
				}
			}
		}
	}
	public void connect2(TreeLinkNode root){
		if (root==null) return; 
		root.next = null;
		for (TreeLinkNode row = root; row.left!=null; row=row.left){
			TreeLinkNode parent = row;
			while(parent!=null){
				parent.left.next = parent.right;
				parent.right.next = parent.next==null? null : parent.next.left;
				parent = parent.next;
			}
		}

	}
}
