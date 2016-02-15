package junxiao.leetcode.sort_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode sortList(ListNode head){
		if (head==null || head.next==null)
			return head;
		ListNode slow = head, fast = head.next;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		ListNode sortedL = sortList(head);
		ListNode sortedR = sortList(head2);
		return mergeList(sortedL, sortedR);
	}
	private ListNode mergeList(ListNode L, ListNode R){
		if (L==null) return R;
		if (R==null) return L;
		ListNode dummy = new ListNode(-1);
		ListNode ptr = dummy;
		while(L!=null && R!=null){
			if(L.val <= R.val){
				ptr.next = L;
				L = L.next;
				ptr = ptr.next;
			}
			else {
				ptr.next =R;
				R = R.next;
				ptr = ptr.next;
			}
		}
		if (L!=null){
			ptr.next = L;
		}
		else 
			ptr.next = R;
		return dummy.next;
	}
}
