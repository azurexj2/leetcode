package junxiao.leetcode.linked_list_cycle_ii;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode detectCycle(ListNode head){
		if (head==null) return null;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if (fast==slow){
				//we meet
				// n: before beet, m: after meet length
				// c: length of circle
				//slow: n + m + i*c
				//fast: n + m + j*c
				//==> n = (j-2i)*c - m
				ListNode slow2 = head;
				while(slow2!=slow){
					slow2=slow2.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
