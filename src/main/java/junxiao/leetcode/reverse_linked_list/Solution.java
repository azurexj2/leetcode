package junxiao.leetcode.reverse_linked_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode reverseList(ListNode head){
		ListNode dummy = null, new_head=null;
		while(head!=null){
			new_head = head;
			head = head.next;
			new_head.next = dummy;
			dummy = new_head;
		}
		return new_head;
	}
}
