package junxiao.leetcode.reorder_list;

import java.util.*;

import org.omg.PortableInterceptor.AdapterStateHelper;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;
import com.sun.xml.internal.org.jvnet.fastinfoset.sax.helpers.FastInfosetDefaultHandler;
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
    	ListNode newHead = head;
    	head = head.next;
    	head.next = null;
    	ListNode tmp;
    	while(head!=null){
    		//insert from begin
    		tmp = newHead;
    		newHead = head;
    		head = head.next;
    		newHead.next = tmp;
    	}
    	return newHead;
    }
    private void mergeList(ListNode head1, ListNode head2){
    	ListNode ptr1 = head1;
    	ListNode ptr2 = head2;
    	ListNode dummy = new ListNode(-1); 
    	ListNode ptr = dummy;
    	while(ptr1!=null && ptr2!=null){
    		ptr.next = ptr1;
    		ptr1 = ptr1.next;
    		ptr = ptr.next;
    		ptr.next = ptr2;
    		ptr2 = ptr2.next;
    		ptr = ptr.next;
    	}
    	if (ptr1!=null){
    		ptr.next = ptr1;
    	}
    	if (ptr2!=null)
    		ptr.next = ptr2;
    }
}
