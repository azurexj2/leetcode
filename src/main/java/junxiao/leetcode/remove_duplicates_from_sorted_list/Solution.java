package junxiao.leetcode.remove_duplicates_from_sorted_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head){
		if (head==null) return head;
		ListNode back = head;
		ListNode front = head.next;
		while(front!=null){
			if (back.val == front.val){
				//duplicate
				back.next = front.next;
				front = back.next;
			}
			else {
				front = front.next;
				back = back.next;
			}
		}
		return head;
	}
}
