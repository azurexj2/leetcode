package junxiao.leetcode.remove_duplicates_from_sorted_list_ii;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head==null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode back = dummy;
		ListNode candidate = dummy.next;
		ListNode front = candidate.next;
		// [] --> [] --> []
		// back   can    front
		//back keep the node we want,
		//only add candiate that front != can
		//
		//if can == front, front++ until front!=candidate, then 
		// back.next = front; can = front, front=front.next;
		//if candidate != front, back=back.next, can=can.next,front=front.next;
		while (front!=null){
		    if (candidate.val!=front.val){
		    	back=back.next;
		    	candidate=candidate.next;
		    	front=front.next;
		    }
		    else{
		    	while(front!=null && front.val==candidate.val){
		    		front = front.next;
		    	}
		    	if (front==null){
		    		back.next=null;
		    		return dummy.next;
		    	}
		    	else {
		    		candidate = front;
		    		back.next = candidate;
		    		front = front.next;
		    	}
		    }
		}
		return dummy.next;
	}
}
