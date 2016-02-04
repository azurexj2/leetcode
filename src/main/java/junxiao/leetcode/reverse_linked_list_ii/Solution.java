package junxiao.leetcode.reverse_linked_list_ii;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n){
		if(head==null || m==n) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode b4_m = dummy;
		ListNode ptr_m = head;
		for(int i=2;i<=m;++i){
			ptr_m = ptr_m.next;
			b4_m = b4_m.next;
		}
		ListNode new_tail = ptr_m;
		ListNode new_head = null, tmp = null;
		for(int i=1;i<n;++i){
			new_head = ptr_m;
			ptr_m=ptr_m.next;
			new_head.next = tmp;
			tmp = new_head;
		}
		ListNode post_n = ptr_m;
		b4_m.next = new_head;
		new_tail.next = post_n;
		return dummy.next;
	}
}
