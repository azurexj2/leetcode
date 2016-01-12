package junxiao.leetcode.swap_nodes_in_pairs;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head==null || head.next==null)
			return head;
		ListNode L = head;
		ListNode R = head.next;
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode newHead = new ListNode(-1);
		newHead = R;
		//a->b->1->2->3->4
		//   pre L  R
		//-----------
		// a->b->2->1->3->4
		//    pre R  L
		while (L!=null && R!=null){
			L.next = R.next;
			R.next = L;
			pre.next = R; 
			
			pre = L;
			L = L.next;
			if (L!=null){
				R = L.next.next;
			}
			else {
				R = null;
			}
		}
		pre.next = L;
		return newHead;
	}
}
