package junxiao.leetcode.copy_list_with_random_pointer;

import java.util.*;
 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head){
		if (head==null) return head;
		Map<Integer, RandomListNode> map = new HashMap<>();
		RandomListNode newHead = new RandomListNode(head.label);
		map.put(head.label, newHead);
		while(head!=null){
			RandomListNode cloned = map.get(head.label);
			if (head.next==null)
				cloned.next=null;
			else {
				RandomListNode next = map.get(head.next.label);
				if (next==null){
					next = new RandomListNode(head.next.label);
					map.put(head.next.label,next);
				}
				cloned.next = next; 
			}
			if (head.random==null)
				cloned.random=null;
			else{
				RandomListNode random = map.get(head.random.label);
				if (random==null){
					random = new RandomListNode(head.random.label);
					map.put(head.random.label,random);
				}
				cloned.random = random;
			}
			head = head.next;
		}
		return newHead;
		
	}
}
