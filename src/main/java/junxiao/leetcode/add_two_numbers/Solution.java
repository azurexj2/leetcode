package junxiao.leetcode.add_two_numbers;

import java.util.*;

import junxiao.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode dummy = new ListNode(-1);
		ListNode ptr = dummy;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0){
			int sum = (l1 == null ? 0 : l1.val) +
					  (l2 == null ? 0 : l2.val) +
					  carry;
			carry = sum / 10;
			sum %= 10;
			ListNode node = new ListNode(sum);
			ptr.next = node;
			ptr = ptr.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		ptr.next = null;
		return dummy.next;
		
	}
}
