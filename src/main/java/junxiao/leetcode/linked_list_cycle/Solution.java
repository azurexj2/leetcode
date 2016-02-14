package junxiao.leetcode.linked_list_cycle;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public boolean hasCycle(ListNode head){
		if (head==null) return false;
		ListNode fast = head;
		ListNode slow = head;
		while(fast!=null && fast.next!=null){
			if (fast.next==slow || fast.next.next==slow){
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}
}
