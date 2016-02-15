package junxiao.leetcode.insertion_sort_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode insertionSortList(ListNode head){
		ListNode ptr = head;
		ListNode sorted = new ListNode(-1);
		sorted.next = null;
		while(ptr!=null){
			ListNode cur = sorted; 
			//find position to insert ptr.val
			//
			while(cur.next!=null && cur.next.val < ptr.val){
			    cur = cur.next;	
			}
			//now cur.val< val <cur.next.val
			//or cur.next == null
				//insert at the middle
			ListNode tmp = cur.next;
			cur.next = ptr;
			ptr = ptr.next;
			cur.next.next = tmp;
		}
		return sorted.next;
	}
}
