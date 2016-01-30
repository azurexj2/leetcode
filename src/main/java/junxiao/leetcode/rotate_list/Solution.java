package junxiao.leetcode.rotate_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public ListNode rotateRight(ListNode head, int k){
		if (head==null || k==0) return head;
		ListNode p1 = head, p2 = head;
		int count = 0;
		//first let p1 move k step or until it reach the end
		while(p1.next!=null && count < k){
			p1 = p1.next;
			++count;
		}
		if (count < k){
			return rotateRight(head,k%(count+1));
		}
		while(p1.next!=null){
			p1=p1.next;
			p2=p2.next;
		}
		p1.next=head;
		head=p2.next;
		p2.next=null;
		return head;
	}
	public ListNode rotateRight2(ListNode head, int k){
		if (head==null || head.next==null || k==0){
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode fast = dummy, slow=dummy;
		int len = 0;
		while(fast.next!=null){
			fast = fast.next;
			++len;
		}
		for(int i =1; i <= len - k%len; ++i){
			slow = slow.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}
}
