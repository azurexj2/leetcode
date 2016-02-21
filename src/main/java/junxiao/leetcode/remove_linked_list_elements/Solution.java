package junxiao.leetcode.remove_linked_list_elements;

import java.util.*;
import junxiao.leetcode.ListNode;
public class Solution {
	public ListNode removeElements(ListNode head, int val){
		if (head == null)return null;
		ListNode dummy = new ListNode(-1);
		ListNode ptr = dummy;
		while(head!=null){
			if (head.val!=val){
				ptr.next = head;
				ptr = ptr.next;
			}
			head = head.next;
		}
		ptr.next = null;
		return dummy.next;
		
	}
}
