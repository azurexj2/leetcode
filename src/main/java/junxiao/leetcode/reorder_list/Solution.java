package junxiao.leetcode.reorder_list;

import java.util.*;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;
import com.sun.xml.internal.ws.api.pipe.NextAction;

import junxiao.leetcode.ListNode;
public class Solution {
	public void reorderList(ListNode head){
		if (head==null || head.next==null) return;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode listEven = slow.next;
		slow.next = null;
		ListNode head2 = reverse(listEven);
		mergeList(head,head2);
	}
    private ListNode reverse(ListNode head){
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	
    	
    }
}
