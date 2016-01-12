package junxiao.leetcode.merge_two_sorted_lists;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode ptr = dummy;
		while (l1!=null && l2!=null){
			if (l1.val <= l2.val){
				ptr.next = l1;
				l1 = l1.next;
			}
			else {
				ptr.next = l2;
				l2 = l2.next;
			}
			ptr = ptr.next;
		}
		ptr.next = l1==null ? l2 : l1;
		return dummy.next;
	}
}
