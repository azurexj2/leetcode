package junxiao.leetcode.reverse_nodes_in_k_group;

import java.util.*;
import junxiao.leetcode.ListNode;
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k){
		if (head==null) return null;
		if (k<=1) return head;
		ListNode dummy = new ListNode(-1);
	    dummy.next = head;	
		ListNode slow = dummy;
		ListNode fast = head;
		while(true){
			for (int i = 1; i<=k; ++i){
				if (fast!=null)
					fast = fast.next;
				else 
					break;
			}
			if (fast==null) break;
			ListNode ptr = slow.next;
			ListNode tmpTail = slow.next;
			ListNode tmpHead = null;
			for (int i = 1; i<=k;++i){
				ListNode tmp = tmpHead;
				tmpHead = ptr;
				ptr = ptr.next;
				tmpHead.next = tmp;
			}
			slow.next = tmpHead;
			tmpTail.next = fast;
			slow = tmpTail;
		}
		return dummy.next;
	}
}
