package junxiao.leetcode.partition_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode partition(ListNode head, int x){
		if (head==null) return head;
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);
		ListNode ptr1 = dummy1;
		ListNode ptr2 = dummy2;
		while(head!=null){
			if (head.val<x){
				ptr1.next=head;
				ptr1=ptr1.next;
			}
			else {
				ptr2.next=head;
				ptr2=ptr2.next;
			}
			head=head.next;
		}
		ptr1.next = dummy2.next;
		ptr2.next = null;
		return dummy1.next;
	}
}
