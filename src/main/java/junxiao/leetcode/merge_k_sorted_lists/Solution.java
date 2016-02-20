package junxiao.leetcode.merge_k_sorted_lists;

import java.util.*;
import junxiao.leetcode.ListNode;
public class Solution {
	public ListNode mergeKLists(ListNode[] lists){
		return sort(lists, 0, lists.length-1);
	}
	private ListNode sort(ListNode[] lists, int i, int j){
		if (i>j) return null;
		if (i==j) return lists[i];
		int m = i + (j-i)/2;
		ListNode l = sort(lists, i, m);
		ListNode r = sort(lists, m+1, j);
		return merge(l, r);
	}
	private ListNode merge(ListNode l1, ListNode l2){
		if (l1==null && l2==null) return null;
		if (l1==null) return l2;
		if (l2==null) return l1;
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while(l1!=null && l2!=null){
			if (l1.val<=l2.val){
				head.next = l1;
				l1 = l1.next;
			}
			else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		head.next = l1==null? l2 : l1;
		return dummy.next;
	}
	public ListNode mergeKLists2(ListNode[] lists){
		int len = lists.length;
		if (len==0) return null;
		if (len==1) return lists[0];
		Queue<ListNode> heap = new PriorityQueue<>(len, new nodeComparator());
		for (int i=0; i<len;++i){
			heap.add(lists[i]);
		}
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while(!heap.isEmpty()){
			ListNode node = heap.remove();
			head.next = node;
			head = head.next;
			if (node.next!=null){
				heap.add(node.next);
			}
			
		}
		return dummy.next;
	}
	private class nodeComparator implements Comparator<ListNode>{
		@Override
		public int compare(ListNode o1, ListNode o2){
			return o1.val - o2.val;
		}
	}
}
