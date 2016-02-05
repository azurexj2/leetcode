package junxiao.leetcode.convert_sorted_list_to_binary_search_tree;

import java.util.*;
import junxiao.leetcode.TreeNode;
import junxiao.leetcode.ListNode;

public class Solution {
	public TreeNode sortedListToBST(ListNode head){
		if(head==null)return null;
		return helper(head,null);
	}
	private TreeNode helper(ListNode head, ListNode tail){
		if (head==tail)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode tree = new TreeNode(slow.val);
		tree.left = helper(head,slow);
		tree.right = helper(slow.next,tail);
		return tree;
	}
}
