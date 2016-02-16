package junxiao.leetcode.intersection_of_two_linked_lists;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		if (headA ==null || headB == null) return null;
		ListNode ptrA = headA, ptrB = headB;
		while(ptrA!=null || ptrB!=null){
			if (ptrA==ptrB)
				return ptrA;
			if (ptrA==null)
				ptrA = headB;
			else
				ptrA=ptrA.next;
			if (ptrB==null)
				ptrB = headA;
			else
				ptrB=ptrB.next;
			
		}
		return null;
	}
}
