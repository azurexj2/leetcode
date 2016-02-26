package junxiao.leetcode.delete_node_in_a_linked_list;

import java.util.*;
import junxiao.leetcode.ListNode;

public class Solution {
	public void deleteNode(ListNode node){
		
		while(node.next!=null){
			node.val = node.next.val;
			if (node.next.next!=null)
				node = node.next;
			else 
				node.next = null;
		}
	}
}
